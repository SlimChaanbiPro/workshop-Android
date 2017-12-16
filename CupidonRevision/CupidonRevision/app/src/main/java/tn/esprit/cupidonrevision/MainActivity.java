package tn.esprit.cupidonrevision;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtFille, edtGarcon;
    public static final String PREFS_JOUEURS = "preferences_cupid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFille = (EditText) findViewById(R.id.edt_nom_fille);
        edtGarcon = (EditText) findViewById(R.id.edt_nom_garcon);

        SharedPreferences preferences = getSharedPreferences(PREFS_JOUEURS, MODE_PRIVATE);
        String nomFille = preferences.getString("nomF", null);
        String nomGarcon = preferences.getString("nomG", null);

        if (nomFille != null){
            edtFille.setText(nomFille);
        }

        if (nomGarcon != null){
            edtGarcon.setText(nomGarcon);
        }
    }

    //Click sur les boutons Annuler, Calculer
    public void onClick(View view){
        if (view.getId() == R.id.btn_annuler){
            edtGarcon.setText("");
            edtFille.setText("");
        }else if (view.getId() == R.id.btn_calculer){
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_JOUEURS, MODE_PRIVATE).edit();
            editor.putString("nomF", edtFille.getText().toString());
            editor.putString("nomG", edtGarcon.getText().toString());
            editor.commit();

            Intent intent = new Intent(this, RatingActivity.class);
            intent.putExtra("nomF", edtFille.getText().toString());
            intent.putExtra("nomG", edtGarcon.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_show){
            startActivity(new Intent(this, ScoresActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

package tn.esprit.cupidonrevision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import tn.esprit.cupidonrevision.dao.CupidDao;
import tn.esprit.cupidonrevision.models.Cupidon;

public class RatingActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView txtValue;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar = (RatingBar) findViewById(R.id.rating);
        txtValue = (TextView) findViewById(R.id.txtValue);

        calculerScore();
    }

    public void onClick(View view){
        if (view.getId() == R.id.btn_recalculer){
            calculerScore();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rating, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_save){
            CupidDao dao = new CupidDao(this);
            Cupidon cupidon = new Cupidon();
            cupidon.setNom_garcon(getIntent().getStringExtra("nomG"));
            cupidon.setNom_fille(getIntent().getStringExtra("nomF"));
            cupidon.setScore(value);
            long idL = dao.insertcupid(cupidon);
            Toast.makeText(this, "ID = "+idL, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void calculerScore(){
        Random generatedInt = new Random();
        value = generatedInt.nextInt(100);
        float floatValue = (float) value*5/100;
        ratingBar.setRating(floatValue);
        txtValue.setText(value+"%");
    }
}

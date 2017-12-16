package tn.esprit.cupidonrevision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import tn.esprit.cupidonrevision.controllers.CupidAdapter;
import tn.esprit.cupidonrevision.dao.CupidDao;
import tn.esprit.cupidonrevision.models.Cupidon;

public class ScoresActivity extends AppCompatActivity {

    ListView lst;
    CupidAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        lst = (ListView) findViewById(R.id.lst);

        CupidDao dao = new CupidDao(this);
        List<Cupidon> cupidons = dao.getAllcupids();

        adapter = new CupidAdapter(this, cupidons);

        lst.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scores, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_reset){
            CupidDao dao = new CupidDao(this);
            dao.deleteAll();
            adapter.clear();
            adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}

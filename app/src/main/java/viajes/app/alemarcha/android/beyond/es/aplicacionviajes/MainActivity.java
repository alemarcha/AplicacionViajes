package viajes.app.alemarcha.android.beyond.es.aplicacionviajes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.adapter.TripAdapter;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.model.Trip;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.rest.ConexionApiRest;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerViewLista = (RecyclerView) findViewById(R.id.my_recycler_view);
        List<Trip> lst = new LinkedList<>();


        recyclerViewLista.setAdapter(new TripAdapter(lst,recyclerViewLista));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewLista.setLayoutManager(layoutManager);


        ConexionApiRest conexionApiRest = new ConexionApiRest("http://free.rome2rio.com/api/1.2/json/Search?key=vsarCcct&oName=London&dName=Madrid&languageCode=ES", recyclerViewLista);
        conexionApiRest.execute();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

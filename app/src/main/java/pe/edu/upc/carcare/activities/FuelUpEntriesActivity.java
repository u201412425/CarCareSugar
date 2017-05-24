package pe.edu.upc.carcare.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import pe.edu.upc.carcare.CarCareApp;
import pe.edu.upc.carcare.R;
import pe.edu.upc.carcare.adapters.FuelUpEntriesAdapter;
import pe.edu.upc.carcare.models.FuelUpEntry;

public class FuelUpEntriesActivity extends AppCompatActivity {
    RecyclerView fuelUpEntriesRecyclerView;
    List<FuelUpEntry> fuelUpEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_up_entries);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getData();

        fuelUpEntriesRecyclerView = (RecyclerView) findViewById(R.id.fuelUpEntriesRecyclerView);
        fuelUpEntriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FuelUpEntriesAdapter fuelUpEntriesAdapter = new FuelUpEntriesAdapter();
        fuelUpEntriesAdapter.setFuelUpEntries(fuelUpEntries);
        fuelUpEntriesRecyclerView.setAdapter(fuelUpEntriesAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AddFuelUpEntryActivity.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        ((FuelUpEntriesAdapter) fuelUpEntriesRecyclerView.getAdapter()).setFuelUpEntries(
                CarCareApp.getInstance().getFuelUpEntries()
        );
        fuelUpEntriesRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private void getData() {
       fuelUpEntries = CarCareApp.getInstance().getFuelUpEntries();
    }

}

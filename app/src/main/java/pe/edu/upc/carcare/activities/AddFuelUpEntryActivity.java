package pe.edu.upc.carcare.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Date;

import pe.edu.upc.carcare.CarCareApp;
import pe.edu.upc.carcare.R;
import pe.edu.upc.carcare.models.FuelUpEntry;

public class AddFuelUpEntryActivity extends AppCompatActivity {
    TextInputEditText gallonsTextInputEditText;
    TextInputEditText unitPriceTextInputEditText;
    TextInputEditText odometerTextInputEditText;
    TextInputEditText locationReferenceTextInputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel_up_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gallonsTextInputEditText = (TextInputEditText) findViewById(R.id.gallonsTextInputEditText);
        unitPriceTextInputEditText = (TextInputEditText) findViewById(R.id.unitPriceTextInputEditText);
        odometerTextInputEditText = (TextInputEditText) findViewById(R.id.odometerTextInputEditText);
        locationReferenceTextInputEditText = (TextInputEditText) findViewById(R.id.locationReferenceTextInputEditText);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FuelUpEntry entry = new FuelUpEntry();
                entry.setGallons(gallonsTextInputEditText.getText().toString())
                        .setFuelType(CarCareApp.getInstance().getFuelTypes().get(0))
                        .setUnitPrice(unitPriceTextInputEditText.getText().toString())
                        .setOdometer(odometerTextInputEditText.getText().toString())
                        .setLocationReference(locationReferenceTextInputEditText.getText().toString())
                        .setCreatedAt(new Date());
                CarCareApp.getInstance().addFuelUpEntry(entry);
                finish();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

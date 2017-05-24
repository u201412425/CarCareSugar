package pe.edu.upc.carcare.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.orm.SugarApp;

import pe.edu.upc.carcare.R;

public class DashboardActivity extends AppCompatActivity {
    TextView gallonsTextView;
    TextView entriesCountTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gallonsTextView = (TextView) findViewById(R.id.gallonsTextView);
        entriesCountTextView = (TextView) findViewById(R.id.entriesCountTextView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), FuelUpEntriesActivity.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void updateData() {
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        String totalGallons = preferences.getString("total_gallons", "0.0");
        String entriesCount = preferences.getString("entries_count", "0");
        gallonsTextView.setText(totalGallons);
        entriesCountTextView.setText(entriesCount);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        updateData();
    }

}

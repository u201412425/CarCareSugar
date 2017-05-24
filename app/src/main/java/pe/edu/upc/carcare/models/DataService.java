package pe.edu.upc.carcare.models;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.edu.upc.carcare.CarCareApp;

/**
 * Created by operador on 4/27/17.
 */

public class DataService {

    public DataService() {
        if(getFuelUpEntries().isEmpty()){
            (new FuelType("Gas 90","90 Oxtanes Gasoline")).save();
            (new FuelType("Gas 97","97 Oxtanes Gasoline")).save();

        }

    }

    public List<FuelType> getFuelTypes() {
        return FuelType.listAll(FuelType.class);
    }

    public List<FuelUpEntry> getFuelUpEntries() {
        return FuelUpEntry.listAll(FuelUpEntry.class);
    }

    public boolean addFuelUpEntry(FuelUpEntry entry) {
        entry.save();
        updatePreferences();
        return true;
    }

    private int getFuelUpEntriesCount() {
        return getFuelUpEntries().size();
    }

    private String getFuelUpEntriesCountAsString() { return String.valueOf(getFuelUpEntriesCount());}

    private double getTotalGallons() {
        double totalGallons = 0;
        for (FuelUpEntry entry :getFuelUpEntries()) totalGallons += entry.getGallons();
        return  totalGallons;
    }

    private String getTotalGallonsAsString() { return String.format("%.2f", getTotalGallons()); }

    private void updatePreferences() {
        SharedPreferences.Editor e = CarCareApp.getInstance()
                .getSharedPreferences("preferences", Context.MODE_PRIVATE).edit();
        e.putString("entries_count", getFuelUpEntriesCountAsString());
        e.putString("total_gallons", getTotalGallonsAsString());
        e.commit();
    }



}

package pe.edu.upc.carcare;

import android.app.Application;

import com.orm.SugarApp;

import java.util.List;

import pe.edu.upc.carcare.models.DataService;
import pe.edu.upc.carcare.models.FuelType;
import pe.edu.upc.carcare.models.FuelUpEntry;

/**
 * Created by operador on 4/27/17.
 */

public class CarCareApp extends SugarApp {
    private DataService service;
    private static CarCareApp instance;

    public CarCareApp() {
        super();
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        service = new DataService();
    }

    public static CarCareApp getInstance() {
        return instance;
    }

    public List<FuelType> getFuelTypes() { return service.getFuelTypes(); }
    public List<FuelUpEntry> getFuelUpEntries() {
        return service.getFuelUpEntries();
    }

    public boolean addFuelUpEntry(FuelUpEntry entry) { return service.addFuelUpEntry(entry); }

}

package pe.edu.upc.carcare.models;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by operador on 4/27/17.
 */

public class FuelUpEntry extends SugarRecord{
    private FuelType fuelType;
    private double gallons;
    private double unitPrice;
    private String odometer;
    private String locationReference;
    private Date createdAt;

    public FuelUpEntry() {
    }

    public FuelUpEntry(FuelType fuelType, double gallons, double unitPrice, String odometer, String locationReference, Date createdAt) {
        this.fuelType = fuelType;
        this.gallons = gallons;
        this.unitPrice = unitPrice;
        this.odometer = odometer;
        this.locationReference = locationReference;
        this.createdAt = createdAt;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public String getFuelTypeName() {
        return fuelType.getName();
    }

    public FuelUpEntry setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public double getGallons() {
        return gallons;
    }

    public String getGallonsAsString() {
        return String.format("%.2f", gallons);
    }

    public FuelUpEntry setGallons(double gallons) {
        this.gallons = gallons;
        return this;
    }

    public FuelUpEntry setGallons(String gallons) {
        return this.setGallons(Double.parseDouble(gallons));
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getUnitPriceAsString() {
        return String.format("%.2f", unitPrice);
    }


    public FuelUpEntry setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public FuelUpEntry setUnitPrice(String unitPrice) {
        return this.setUnitPrice(Double.parseDouble(unitPrice));
    }

    public double getPrice() {
        return gallons*unitPrice;
    }

    public String getPriceAsString() {
        return String.format("%.2f", getPrice());
    }

    public String getOdometer() {
        return odometer;
    }

    public FuelUpEntry setOdometer(String odometer) {
        this.odometer = odometer;
        return this;
    }

    public String getLocationReference() {
        return locationReference;
    }

    public FuelUpEntry setLocationReference(String locationReference) {
        this.locationReference = locationReference;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public FuelUpEntry setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getCreatedAtAsString() {
        return (new SimpleDateFormat("EEEE, MMMM d yyyy")).format(createdAt);
    }

    public String getContextAsString() {
        return "On " + getCreatedAtAsString() + (locationReference.isEmpty() ? "" : " at " + locationReference);
    }
}












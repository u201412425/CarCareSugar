package pe.edu.upc.carcare.models;

import com.orm.SugarRecord;

/**
 * Created by operador on 4/27/17.
 */

public class FuelType extends SugarRecord{
    private String name;
    private String description;

    public FuelType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public FuelType() {
    }

    public String getName() {
        return name;
    }

    public FuelType setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FuelType setDescription(String description) {
        this.description = description;
        return this;
    }
}

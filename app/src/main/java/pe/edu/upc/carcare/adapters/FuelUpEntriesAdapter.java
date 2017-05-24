package pe.edu.upc.carcare.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.carcare.R;
import pe.edu.upc.carcare.models.FuelUpEntry;

/**
 * Created by operador on 4/27/17.
 */

public class FuelUpEntriesAdapter extends RecyclerView.Adapter<FuelUpEntriesAdapter.ViewHolder> {
    private List<FuelUpEntry> fuelUpEntries;

    @Override
    public FuelUpEntriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_fuel_up_entry, parent, false));

    }

    @Override
    public void onBindViewHolder(FuelUpEntriesAdapter.ViewHolder holder, int position) {
        holder.fuelTypeTextView.setText(fuelUpEntries.get(position).getFuelTypeName());
        holder.gallonsTextView.setText(fuelUpEntries.get(position).getGallonsAsString());
        holder.contextTextView.setText(fuelUpEntries.get(position).getContextAsString());
        holder.priceTextView.setText(fuelUpEntries.get(position).getPriceAsString());
    }

    @Override
    public int getItemCount() {
        return fuelUpEntries.size();
    }

    public List<FuelUpEntry> getFuelUpEntries() {
        return fuelUpEntries;
    }

    public void setFuelUpEntries(List<FuelUpEntry> fuelUpEntries) {
        this.fuelUpEntries = fuelUpEntries;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fuelTypeTextView;
        TextView gallonsTextView;
        TextView priceTextView;
        TextView contextTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            fuelTypeTextView = (TextView) itemView.findViewById(R.id.fuelTypeTextView);
            gallonsTextView = (TextView) itemView.findViewById(R.id.gallonsTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
            contextTextView = (TextView) itemView.findViewById(R.id.contextTextView);
        }
    }
}

package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.R;

/**
 * Created by alemarcha26 on 30/11/15.
 */
public class TripViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private TextView from;
    private TextView to;
    private TextView duration;
    private TextView price;
    private TextView distance;
    private TextView vehicle;
    private ItemClickListener clickListener;

    public TripViewHolder(View itemView) {
        super(itemView);
        from= (TextView) itemView.findViewById(R.id.textViewFrom);
        to= (TextView) itemView.findViewById(R.id.textViewTo);
        duration=(TextView) itemView.findViewById(R.id.timeEstimated);
        price=(TextView) itemView.findViewById(R.id.priceEstimated);
        distance=(TextView) itemView.findViewById(R.id.vehicle);
        vehicle=(TextView) itemView.findViewById(R.id.distance);
        itemView.setTag(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setFrom(String from, String countryFrom) {
        this.from.setText(from+"("+countryFrom+")");
    }

    public void setTo(String to, String countryTo) {

        this.to.setText(to+"("+countryTo+")");
    }


    public void setDuration(String duration) {
        this.duration.setText(duration);
    }

    public void setPrice(String price) {
        this.price.setText(price);
    }

    public void setDistance(String distance) {
        this.distance.setText(distance);;
    }

    public void setVehicle(String vehicle) {
        this.vehicle.setText(vehicle);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    @Override
    public void onClick(View view) {
        clickListener.onClick(view, getAdapterPosition(), false);
    }
    @Override
    public boolean onLongClick(View view) {
        clickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }
}

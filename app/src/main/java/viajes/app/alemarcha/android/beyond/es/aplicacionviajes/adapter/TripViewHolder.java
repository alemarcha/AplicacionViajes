package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.R;

/**
 * Created by alemarcha26 on 30/11/15.
 */
public class TripViewHolder extends RecyclerView.ViewHolder {
    private TextView from;
    private TextView to;


    public TripViewHolder(View itemView) {
        super(itemView);
        from= (TextView) itemView.findViewById(R.id.textViewFrom);
        to= (TextView) itemView.findViewById(R.id.textViewTo);
    }

    public void setFrom(String from, String countryFrom) {
        this.from.setText(from+"("+countryFrom+")");
    }

    public void setTo(String to, String countryTo) {

        this.to.setText(to+"("+countryTo+")");
    }

}

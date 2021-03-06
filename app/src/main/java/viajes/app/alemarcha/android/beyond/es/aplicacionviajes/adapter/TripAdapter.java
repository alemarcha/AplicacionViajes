package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.DAO.TripDAO;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.DetailActivity;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.MainActivity;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.R;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.model.Trip;


/**
 * Created by alemarcha26 on 30/11/15.
 */
public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {

    private List<Trip> listTrips;
    private RecyclerView recyclerViewLista;

    public TripAdapter(List<Trip> listTrips, RecyclerView recyclerViewLista) {
        this.listTrips = listTrips;
        this.recyclerViewLista=recyclerViewLista;
        TripDAO.save(listTrips);
    }
    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p/>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p/>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Es el método que se utiliza cuando se crea por primera vez el holder
        View tripHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_element, parent, false);

        return new TripViewHolder(tripHolder);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p/>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p/>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle effcient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(TripViewHolder holder, int position) {
        // Es el que se utiliza para rellenar el holder
        final Trip tripActual=listTrips.get(position);
        holder.setFrom(tripActual.getFrom(), tripActual.getCountryFrom());
        holder.setTo(tripActual.getTo(), tripActual.getCountryTo());
        holder.setPrice(tripActual.getPrice());
        holder.setDuration(tripActual.getDuration());
        holder.setDistance(tripActual.getDistance());
        holder.setVehicle(tripActual.getVehicle());
        // Esto lo hacemos con una nueva clase pero realmente no haría falta, se podría hacer directamente View.OnClickListener
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
              //  Toast.makeText(view.getContext(), "#" + position + " - " + listTrips.get(position).getPrice() + " (Long click)", Toast.LENGTH_SHORT).show();
                Intent mensaje = new Intent(view.getContext(), DetailActivity.class);
                mensaje.putExtra(DetailActivity.POS_ELEMENT_DETAIL,position);
                mensaje.putExtra(DetailActivity.ELEMENT_DETAIL_IMG,tripActual.getURLImg());
                view.getContext().startActivity(mensaje);
            }
        });
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return listTrips.size();
    }
}

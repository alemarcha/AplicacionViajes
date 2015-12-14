package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.rest;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.adapter.TripAdapter;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.dto.AirlinesDTO;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.dto.RoutesDTO;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.dto.TripDTO;
import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.model.Trip;

/**
 * Created by alemarcha26 on 3/12/15.
 */
public class ConexionApiRest extends AsyncTask<Void, Void, TripDTO> {

    private String urlApi;
    private RecyclerView recyclerViewLista;
    private List<Trip> trips;


    public ConexionApiRest(String urlApi,RecyclerView recyclerViewLista) {
        this.urlApi = urlApi;
        this.recyclerViewLista=recyclerViewLista;
    }


    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected TripDTO doInBackground(Void... params) {
        TripDTO tripRes=null;

        try {
            Uri builtUri = Uri.parse(urlApi);


            URL url = new URL(builtUri.toString());

          /*  HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream input = urlConnection.getInputStream();

            List<String> lineas = IOUtils.readLines(input, null);
            String result = StringUtils.join(lineas);
*/
            ObjectMapper mapper = new ObjectMapper();

            tripRes = mapper.readValue(url, TripDTO.class);
            //Log.d("JSON", result);
            Log.i("PRUEBA","PRUEBA");
            //response = new JSONObject(result.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("ERROR MALFORMEDURL", "Se ha producido un error al obtener los datos de la api");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ERROR IOException", "Se ha producido un error al obtener los datos de la api");
        }


        return tripRes;
    }


    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     * <p/>
     * <p>This method won't be invoked if the task was cancelled.</p>
     *
     * @param tripDTO The result of the operation computed by {@link #doInBackground}.
     * @see #onPreExecute
     * @see #doInBackground
     * @see #onCancelled(Object)
     */
    @Override
    protected void onPostExecute(TripDTO tripDTO) {
        super.onPostExecute(tripDTO);
        trips=new ArrayList<Trip>();

        for (RoutesDTO routes: tripDTO.getRoutes()) {
            Trip t=new Trip();
            t.setDuration(routes.getDuration().toString() + " minutos");
            t.setPrice(routes.getIndicativePrice().getPrice() + " " + routes.getIndicativePrice().getCurrency());
            t.setVehicle(routes.getName());
            t.setDistance(routes.getDistance() + " KM");
            if(!tripDTO.getPlaces().isEmpty() && tripDTO.getPlaces().size()==2){
                t.setFrom(tripDTO.getPlaces().get(0).getName());
                t.setCountryFrom(tripDTO.getPlaces().get(0).getCountryCode());
                t.setTo(tripDTO.getPlaces().get(1).getName());
                t.setCountryTo(tripDTO.getPlaces().get(1).getCountryCode());
            }else{
                t.setFrom("Origen desconocido");
                t.setFrom("Destino desconocido");
            }

            if(tripDTO.getAirlines()!=null &&  !tripDTO.getAirlines().isEmpty()){
                AirlinesDTO airline=tripDTO.getAirlines().get((int)Math.random() * tripDTO.getAirlines().size());
                String urlImg = "http://www.rome2rio.com" + airline.getIconPath();
                t.setURLImg(urlImg);
            }

            trips.add(t);
        }


        TripAdapter adapter=new TripAdapter(trips,recyclerViewLista);
        recyclerViewLista.setAdapter(adapter);
    }
}

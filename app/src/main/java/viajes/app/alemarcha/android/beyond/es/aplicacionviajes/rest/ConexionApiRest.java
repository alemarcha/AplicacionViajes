package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.rest;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by alemarcha26 on 3/12/15.
 */
public class ConexionApiRest extends AsyncTask<Void, Void, Void> {

    private String urlApi;

    public ConexionApiRest(String urlApi) {
        this.urlApi = urlApi;
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
    protected Void doInBackground(Void... params) {
        try {
            Uri builtUri = Uri.parse(urlApi);


            URL url = new URL(builtUri.toString());

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream input = urlConnection.getInputStream();

            List<String> lineas = IOUtils.readLines(input, null);
            String result = StringUtils.join(lineas);

            Log.d("JSON", result);
            Log.i("PRUEBA","PRUEBA");
            //response = new JSONObject(result.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("ERROR MALFORMEDURL", "Se ha producido un error al obtener los datos de la api");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ERROR IOException", "Se ha producido un error al obtener los datos de la api");
        }


        return null;
    }
}

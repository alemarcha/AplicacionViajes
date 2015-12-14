package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.DAO;

import java.util.ArrayList;
import java.util.List;

import viajes.app.alemarcha.android.beyond.es.aplicacionviajes.model.Trip;

/**
 * Created by alemarcha26 on 14/12/15.
 */
public class TripDAO {

    private static List<Trip> lista;

    public static void save(List<Trip> lstTrip){
        if(lista!=null){
            lista.clear();
            lista.addAll(lstTrip);
        }else{
            lista=new ArrayList<>(lstTrip);
        }

    }

    public static List<Trip> list(List<Trip> lstTrip){
        return lista;
    }

    public static  Trip getProductById(Integer pos){
        return lista.get(pos);
    }
}

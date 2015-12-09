package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by alemarcha26 on 3/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripDTO {

    @JsonProperty("serveTime")
    private String serveTime;
    @JsonProperty("places")
    private List<PlacesDTO> places;
    @JsonProperty("routes")
    private List<RoutesDTO> routes;

    public TripDTO() {
    }

    public String getServeTime() {
        return serveTime;
    }

    public void setServeTime(String serveTime) {
        this.serveTime = serveTime;
    }

    public List<PlacesDTO> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlacesDTO> places) {
        this.places = places;
    }

    public List<RoutesDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutesDTO> routes) {
        this.routes = routes;
    }
}

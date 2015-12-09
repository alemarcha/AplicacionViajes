package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.model;

/**
 * Created by alemarcha26 on 30/11/15.
 */
public class Trip {
    private String from;
    private String to;
    private String countryTo;
    private String countryFrom;
    private String price;
    private String duration;
    private String distance;
    private String vehicle;

    public Trip() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }



    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(String countryTo) {
        this.countryTo = countryTo;
    }

    public String getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}

package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.model;

/**
 * Created by alemarcha26 on 30/11/15.
 */
public class Trip {
    private String from;
    private String to;
    private String checkOut;
    private String arrivalTime;


    public Trip() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

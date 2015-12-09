package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alemarcha26 on 3/12/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoutesDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("distance")
    private long distance;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("totalTransferDuration")
    private Integer totalTransferDuration;
    @JsonProperty("indicativePrice")
    private IndicativePriceDTO indicativePrice;

    public RoutesDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTotalTransferDuration() {
        return totalTransferDuration;
    }

    public void setTotalTransferDuration(Integer totalTransferDuration) {
        this.totalTransferDuration = totalTransferDuration;
    }

    public IndicativePriceDTO getIndicativePrice() {
        return indicativePrice;
    }

    public void setIndicativePrice(IndicativePriceDTO indicativePrice) {
        this.indicativePrice = indicativePrice;
    }
}

package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alemarcha26 on 9/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicativePriceDTO {

    @JsonProperty("price")
    private long price;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isFreeTransfer")
    private Integer isFreeTransfer;

    public IndicativePriceDTO() {
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getIsFreeTransfer() {
        return isFreeTransfer;
    }

    public void setIsFreeTransfer(Integer isFreeTransfer) {
        this.isFreeTransfer = isFreeTransfer;
    }
}

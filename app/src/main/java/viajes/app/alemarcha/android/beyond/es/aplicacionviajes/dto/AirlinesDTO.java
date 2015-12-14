package viajes.app.alemarcha.android.beyond.es.aplicacionviajes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alemarcha26 on 14/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirlinesDTO {

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("iconPath")
    private String iconPath;
    @JsonProperty("iconSize")
    private String iconSize;
    @JsonProperty("iconOffset")
    private String iconOffset;

    public AirlinesDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getIconSize() {
        return iconSize;
    }

    public void setIconSize(String iconSize) {
        this.iconSize = iconSize;
    }

    public String getIconOffset() {
        return iconOffset;
    }

    public void setIconOffset(String iconOffset) {
        this.iconOffset = iconOffset;
    }
}

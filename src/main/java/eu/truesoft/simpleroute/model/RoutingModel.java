package eu.truesoft.simpleroute.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoutingModel {
    private String cca3;
    private List<String> borders;

    public RoutingModel() {
    }

    public RoutingModel(String cca3, List<String> borders) {
        this.cca3 = cca3;
        this.borders = borders;
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "cca3='" + cca3 + '\'' +
                ", borders=" + borders +
                '}';
    }
}

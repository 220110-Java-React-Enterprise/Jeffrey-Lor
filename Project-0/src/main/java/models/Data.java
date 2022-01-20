package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private Card[] data;

    public Data() {
        data = new Card[1];
    }

    public Card[] getData() {
        return this.data;
    }

    public void setData(Card[] data) {
        this.data = data;
    }

}
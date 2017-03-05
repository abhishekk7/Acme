package acme.bot.models;

/**
 * Created by abhis on 3/5/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchCriteria {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("ecommerce")
    @Expose
    private String ecommerce;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("critera")
    @Expose
    private String critera;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("keyword")
    @Expose
    private Keyword keyword;

    @SerializedName("complete")
    @Expose
    private boolean complete;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEcommerce() {
        return ecommerce;
    }

    public void setEcommerce(String ecommerce) {
        this.ecommerce = ecommerce;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getCritera() {
        return critera;
    }

    public void setCritera(String critera) {
        this.critera = critera;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
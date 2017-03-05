package acme.bot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abhis on 3/4/2017.
 */

public class SearchResult {
    @SerializedName("message")
    @Expose
    public String message;

    SearchResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

package acme.bot.models;

/**
 * Created by abhis on 3/5/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Keyword {

    @SerializedName("lis")
    @Expose
    private List<String> lis = null;

    public List<String> getLis() {
        return lis;
    }

    public void setLis(List<String> lis) {
        this.lis = lis;
    }

}
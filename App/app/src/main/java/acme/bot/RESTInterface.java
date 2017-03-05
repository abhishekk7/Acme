package acme.bot;

import acme.bot.models.SearchCriteria;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by abhis on 3/4/2017.
 */

public interface RESTInterface {
    @POST("extractionendpoint")
    Call<SearchCriteria> getSearchResults(
            @Body SearchCriteria searchCriteria);
}

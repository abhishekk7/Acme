package com.acme.service;

/**
 * Created by abhis on 3/4/2017.
 */

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("extractionendpoint")
public class ExtractionEndPoint {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    public String getIt(@QueryParam("searchCriteria") String name) {
        return name;
    }
}

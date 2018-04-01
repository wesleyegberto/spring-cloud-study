package com.github.wesleyegberto.netflixstackstudy.kyron.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/ping")
public class PingResource {

    @GET
    public String ping() {
        return "pong";
    }
}

package com.github.wesleyegberto.netflixstackstudy.kyron;

import netflix.karyon.health.HealthCheckHandler;

public class PingCheckHandler implements HealthCheckHandler {
    @Override
    public int getStatus() {
        return 200;
    }
}

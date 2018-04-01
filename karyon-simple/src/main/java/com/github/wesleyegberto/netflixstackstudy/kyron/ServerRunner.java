package com.github.wesleyegberto.netflixstackstudy.kyron;

import com.netflix.governator.annotations.Modules;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.KaryonBootstrap;
import netflix.karyon.KaryonRunner;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrap;
import netflix.karyon.jersey.blocking.KaryonJerseyModule;
import netflix.karyon.servo.KaryonServoModule;

@ArchaiusBootstrap
@KaryonBootstrap(name = "ping-service", healthcheck = PingCheckHandler.class)
@Modules(include = {
    ShutdownModule.class,
    KaryonWebAdminModule.class,
    KaryonServoModule.class,
    ServerRunner.JerseyModuleImpl.class
})
public class ServerRunner {
    static class JerseyModuleImpl extends KaryonJerseyModule {

        @Override
        protected void configureServer() {
            server().port(8090).threadPoolSize(50);
        }
    }

    public static void main(String[] args) {
        KaryonRunner.main(new String[] {
            ServerRunner.class.getCanonicalName()
        });
    }
}

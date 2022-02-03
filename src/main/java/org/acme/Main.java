package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;

@QuarkusMain
@ApplicationScoped
public class Main implements QuarkusApplication {

    @Inject
    CommandLine.IFactory factory;

    private static final Logger STATIC_LOGGER = Logger.getLogger("staticLogger");

    public static void main(String ... args) { 
        STATIC_LOGGER.info("Main method");
        Quarkus.run(Main.class, args);
    }


    @Override
    public int run(String... args) throws Exception {
        return new CommandLine(new HelloCommand(), factory).execute(args); 
    }

}
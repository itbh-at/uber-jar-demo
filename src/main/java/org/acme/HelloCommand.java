package org.acme;

import picocli.CommandLine;

import org.jboss.logging.Logger;

@CommandLine.Command 
public class HelloCommand implements Runnable {

    @CommandLine.Option(names = {"-n", "--name"}, description = "Who will we greet?", defaultValue = "World")
    String name;

    @Override
    public void run() {
        Logger.getLogger("inCommand").infof("Saying '%s'", name);
    }
}

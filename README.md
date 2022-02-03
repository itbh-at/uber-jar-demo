# uber-jar-demo Project

This project demos logger format configuration being ignored in a uber-jar
as soon as there is a custom main method in a picocli application.

Console log format is set to `%d{yyyy-MM-dd HH:mm:ss} %-5p [%c] %s%e%n` in 
`application.properties` but the log output on the console looks like this:

```
cdh:~/uber-jar-demo$ java -jar target/uber-jar-demo-1.0.0-SNAPSHOT-runner.jar
Feb 03, 2022 5:56:23 AM org.acme.Main main
INFO: Main method
Feb 03, 2022 5:56:23 AM org.jboss.threads.Version <clinit>
INFO: JBoss Threads version 3.4.2.Final
Feb 03, 2022 5:56:23 AM io.quarkus.bootstrap.runner.Timing printStartupTime
INFO: uber-jar-demo 1.0.0-SNAPSHOT on JVM (powered by Quarkus 2.6.3.Final) started in 0.438s. 
Feb 03, 2022 5:56:23 AM io.quarkus.bootstrap.runner.Timing printStartupTime
INFO: Profile prod activated. 
Feb 03, 2022 5:56:23 AM io.quarkus.bootstrap.runner.Timing printStartupTime
INFO: Installed features: [cdi, picocli]
Feb 03, 2022 5:56:23 AM org.acme.HelloCommand run
INFO: Saying 'World'
Feb 03, 2022 5:56:23 AM io.quarkus.bootstrap.runner.Timing printStopTime
INFO: uber-jar-demo stopped in 0.030s
__  ____  __  _____   ___  __ ____  ______ 
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
```

Packaging a fast-jar and running the application does all the pretty-printing:

```
__  ____  __  _____   ___  __ ____  ______ 
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
2022-02-03 06:00:56 INFO  [staticLogger] Main method
2022-02-03 06:00:56 INFO  [io.quarkus] uber-jar-demo 1.0.0-SNAPSHOT on JVM (powered by Quarkus 2.6.3.Final) started in 0.517s. 
2022-02-03 06:00:56 INFO  [io.quarkus] Profile prod activated. 
2022-02-03 06:00:56 INFO  [io.quarkus] Installed features: [cdi, picocli]
2022-02-03 06:00:57 INFO  [inCommand] Saying 'World'
2022-02-03 06:00:57 INFO  [io.quarkus] uber-jar-demo stopped in 0.031s
```

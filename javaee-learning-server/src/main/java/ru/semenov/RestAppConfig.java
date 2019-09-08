package ru.semenov;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestAppConfig extends Application {

    public RestAppConfig() {
    }
}

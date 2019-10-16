package ru.semenov;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


// OpenAPI URL: http://localhost:8080/javaee-learning/rest/openapi.json
@ApplicationPath("/rest")
public class RestAppConfig extends Application {

    public RestAppConfig() {
    }
}

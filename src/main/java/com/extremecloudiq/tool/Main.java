package com.extremecloudiq.tool;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class Main {
    public static void main(String[] args) {
        configureFor("172.16.1.10",8280);

        removeAllMappings();

        stubFor(get(urlPathEqualTo("/user/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("test.json")));
    }
}
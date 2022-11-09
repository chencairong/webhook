package com.extremecloudiq.tool;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class Main {
    public static void main(String[] args) {
        configureFor("vip.ddns.name", 8280);

        removeAllMappings();

        stubFor(post(urlPathEqualTo("/alerts"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("test.json")));
    }
}
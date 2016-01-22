package com.quidquid.my_api

import com.twitter.finagle.http.Status
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class TestsControllerFeatureTest extends FeatureTest {
  override val server: EmbeddedHttpServer = new EmbeddedHttpServer( twitterServer = new MyAPIServer)

  "Tests - ping" in {
    server.httpGet(
      path = "/ping",
      andExpect = Status.Ok,
      withBody = "pong"
    )
  }
}
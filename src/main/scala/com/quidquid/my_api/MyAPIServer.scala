package com.quidquid.my_api
 
import com.quidquid.my_api.controllers._
import com.quidquid.my_api.modules.{DBConfModule, MyAPIWarmupHandler}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
 
object MyAPIMain extends MyAPIServer
 
class MyAPIServer extends HttpServer {
 
  override def configureHttp(router: HttpRouter): Unit = {
    router.add[TestsController]
  }
 
  override val modules = Seq(
    DBConfModule
  )
 
  override def warmup() {
    run[MyAPIWarmupHandler]()
  }
}
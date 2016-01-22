package com.quidquid.my_api.controllers
 
import java.sql.ResultSet
 
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import org.jooq.{Result, Record}
import com.quidquid.my_api.DBSupport._
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class TestsController extends Controller {
 
  get("/ping") { request: Request =>
    "pong"
  }
 
  get("/users") { request: Request =>
    val sql = "SELECT * FROM users"
    val rs: ResultSet = ds.getConnection.createStatement().executeQuery(sql)
    val result: Result[Record] = db.fetch(rs)
    var list = new ListBuffer[User]()
    for (r: Record <- result) {
      val id: Int = r.getValue("id").asInstanceOf[Int]
      val email: String = r.getValue("email").asInstanceOf[String]
      val pass: String = r.getValue("password").asInstanceOf[String]
      list += User(id, email, pass)
    }
    response.ok.json(list)
  }
}
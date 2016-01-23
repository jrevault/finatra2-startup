package fr.quidquid.my_api
 
import java.util.Properties
 
import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import org.jooq.impl.DSL
import org.jooq.{DSLContext, SQLDialect}
 
object DBSupport {
 
  var db: DSLContext = _
  var ds: HikariDataSource = _
 
  def db_configure(db_props: Properties) {
    ds = new HikariDataSource(new HikariConfig(db_props))
    db = DSL.using(ds, SQLDialect.MYSQL)
  }
}
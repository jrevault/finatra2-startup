package com.quidquid.my_api.modules
 
import java.util.Properties
 
import com.google.inject.Provides
import com.twitter.inject.TwitterModule
 
/**
  * Reads from flags.
  * Flag usage by starting server with arguments ex:
  * java -jar target/myserver-1.0.0-SNAPSHOT.jar \
  * -db.class=com.mysql.jdbc.jdbc2.optional.MysqlDataSource \
  * -db.host=127.0.0.1 -db.port=3306 \
  * -db.name=quidquid_db -db.user=my_user -db.pass=my_secret
  */
object DBConfModule extends TwitterModule {
 
  val ds_class = flag("db.class", "com.mysql.jdbc.jdbc2.optional.MysqlDataSource", "Mysql for dev")
  val ds_host = flag("db.host", "127.0.0.1", "Host name or IP address. (127.0.0.1)")
  val ds_port = flag("db.port", "3306", "Database port. (3306)")
  val ds_name = flag("db.name", "quidquid_db", "Database name. (quidquid_db)")
  val ds_user = flag("db.user", "my_user", "DB user name")
  val ds_pass = flag("db.pass", "my_secret", "The password")
 
  @Provides
  def get_props: Properties = {
    val db_props: Properties = new Properties
    db_props.setProperty("dataSourceClassName", ds_class())
    db_props.setProperty("dataSource.serverName", ds_host())
    db_props.setProperty("dataSource.port", ds_port())
    db_props.setProperty("dataSource.databaseName", ds_name())
    db_props.setProperty("dataSource.user", ds_user())
    db_props.setProperty("dataSource.password", ds_pass())
    db_props
  }
}
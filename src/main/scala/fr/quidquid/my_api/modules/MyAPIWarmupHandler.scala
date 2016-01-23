package fr.quidquid.my_api.modules
 
import java.util.Properties
import javax.inject.Inject
 
import fr.quidquid.my_api.DBSupport
import com.twitter.finatra.utils.Handler
 
class MyAPIWarmupHandler @Inject()(db_props: Properties) extends Handler {
 
  override def handle() = {
    DBSupport.db_configure(db_props)
  }
}
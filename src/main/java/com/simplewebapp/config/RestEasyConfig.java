import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import org.jboss.resteasy.spi.ResteasyDeployment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by Zhangariny on 24/07/2015.
 */
@Configuration
public class RestEasyConfig {

  @Resource
  private Environment environment;

  @Bean(initMethod = "start", destroyMethod = "stop")
  public ResteasyDeployment resteasyDeployment() {
    ResteasyDeployment resteasyDeployment = new ResteasyDeployment();
    resteasyDeployment.setAsyncJobServiceEnabled(true);
    Map mediaTypeMapping = new HashMap();
    mediaTypeMapping.put("json", "application/json");
    mediaTypeMapping.put("xml", "application/xml");
    resteasyDeployment.setMediaTypeMappings(mediaTypeMapping);
    return resteasyDeployment;

  }
}

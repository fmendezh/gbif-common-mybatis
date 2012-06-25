package org.gbif.mybatis.guice;

import java.util.Properties;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.datasource.bonecp.BoneCPProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic mybatis module using BoneCP and offers a simple Property based option to turn on caching by setting
 * cache=true.
 */
public abstract class MyBatisModule extends org.mybatis.guice.MyBatisModule {

  private final Properties properties;
  private static final String CACHE_KEY = "cache";
  private static final Logger LOG = LoggerFactory.getLogger(MyBatisModule.class);

  /**
   * Properties with potential prefix scope already being removed.
   */
  protected MyBatisModule(Properties properties) {
    this.properties = properties;
  }

  @Override
  protected void initialize() {
    boolean useCache = false;
    if (properties.containsKey(CACHE_KEY)) {
      String x = properties.getProperty(CACHE_KEY);
      try {
        useCache = x != null && Boolean.parseBoolean(x);
      } catch (Exception e) {
        LOG.error("Bad configuration found for {}; {}", CACHE_KEY, x);
      }
    }
    useCacheEnabled(useCache);
    if (useCache) {
      LOG.info("Configuring registry persitance with cache");
      environmentId("production");
    } else {
      LOG.info("Configuring registry persitance with NO cache");
      environmentId("development");
    }

    bindTransactionFactoryType(JdbcTransactionFactory.class);
    bindMappers();
    bindTypeHandlers();
    bindManagers();

    // TODO: Make configurable somehow? Load from classname property.
    // Couldn't figure out how to do that with the generics though.
    bindDataSourceProviderType(BoneCPProvider.class);
  }

  abstract protected void bindMappers();

  abstract protected void bindTypeHandlers();

  abstract protected void bindManagers();

}

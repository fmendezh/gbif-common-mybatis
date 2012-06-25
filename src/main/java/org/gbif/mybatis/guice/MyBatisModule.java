package org.gbif.mybatis.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.datasource.bonecp.BoneCPProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic mybatis module using BoneCP and offers an optional Named guice setting to turn on caching by binding
 * a Boolean "cache".
 */
public abstract class MyBatisModule extends org.mybatis.guice.MyBatisModule {

  private static final Logger LOG = LoggerFactory.getLogger(MyBatisModule.class);

  @Inject(optional = true)
  @Named("cache")
  private Boolean useCache;

  protected boolean useCache() {
    return useCache != null && useCache;
  }

  @Override
  protected void initialize() {

    useCacheEnabled(useCache());
    if (useCache()) {
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

  /**
   * Implement method to bind the mybatis mappers to be used.
   */
  abstract protected void bindMappers();

  /**
   * Implement method to bind the mybatis type handlers to be used.
   */
  abstract protected void bindTypeHandlers();

  /**
   * Implement method to bind the managers/services.
   */
  abstract protected void bindManagers();

}

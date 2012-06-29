package org.gbif.mybatis.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic mybatis module using BoneCP and offers an optional Named guice setting to turn on caching by binding
 * a Boolean "enableCache".
 */
public abstract class MyBatisModule extends org.mybatis.guice.MyBatisModule {

  private static final Logger LOG = LoggerFactory.getLogger(MyBatisModule.class);

  @Inject(optional = true)
  @Named("enableCache")
  private Boolean useCache;

  protected boolean useCache() {
    return useCache != null && useCache;
  }

  @Override
  protected void initialize() {

    useCacheEnabled(useCache());
    if (useCache()) {
      LOG.info("Configuring MyBatis with cache");
      environmentId("production");
    } else {
      LOG.info("Configuring MyBatis with no cache");
      environmentId("development");
    }

    bindTransactionFactoryType(JdbcTransactionFactory.class);
    bindMappers();
    bindTypeHandlers();
    bindManagers();

    bindDataSourceProviderType(BoneCPExtendedProvider.class);
  }

  /**
   * Implement method to bind the mybatis mappers to be used.
   */
  protected abstract void bindMappers();

  /**
   * Implement method to bind the mybatis type handlers to be used.
   */
  protected abstract void bindTypeHandlers();

  /**
   * Implement method to bind the managers/services.
   */
  protected abstract void bindManagers();

}

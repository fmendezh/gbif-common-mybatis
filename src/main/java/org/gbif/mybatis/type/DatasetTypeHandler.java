package org.gbif.mybatis.type;

import org.gbif.api.model.vocabulary.DatasetType;

/**
 * Handler for the DatasetType Enum.
 */
public class DatasetTypeHandler extends BaseEnumTypeHandler<Integer, DatasetType> {

  public DatasetTypeHandler() {
    super(new DatasetTypeConverter());
  }
}

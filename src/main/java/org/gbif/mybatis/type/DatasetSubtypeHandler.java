package org.gbif.mybatis.type;

import org.gbif.api.model.vocabulary.DatasetSubtype;

/**
 * Handler for the DatasetSubtypeType Enum.
 */
public class DatasetSubtypeHandler extends BaseEnumTypeHandler<Integer, DatasetSubtype> {

  public DatasetSubtypeHandler() {
    super(new DatasetSubtypeConverter());
  }
}

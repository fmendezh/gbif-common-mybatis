package org.gbif.mybatis.type;

import org.gbif.api.model.vocabulary.DatasetType;

import com.google.common.collect.ImmutableMap;

import static org.gbif.api.model.vocabulary.DatasetType.CHECKLIST;
import static org.gbif.api.model.vocabulary.DatasetType.METADATA;
import static org.gbif.api.model.vocabulary.DatasetType.OCCURRENCE;

/**
 * Converter class for DatasetType Enum using an immutable bimap for mapping key/values.
 */
public class DatasetTypeConverter extends BaseConverter<Integer, DatasetType> {

  /**
   * @throws IllegalArgumentException if two keys have the same value
   */
  public DatasetTypeConverter() {
    super(null, new ImmutableMap.Builder<Integer, DatasetType>()
        .put(19000, CHECKLIST)
        .put(19010, OCCURRENCE)
        .put(19020, METADATA)
        .build());
  };
}

package org.gbif.mybatis.type;

import org.gbif.api.model.vocabulary.DatasetSubtype;

import com.google.common.collect.ImmutableMap;

import static org.gbif.api.model.vocabulary.DatasetSubtype.DERIVED_FROM_OCCURRENCE;
import static org.gbif.api.model.vocabulary.DatasetSubtype.GLOBAL_SPECIES_DATASET;
import static org.gbif.api.model.vocabulary.DatasetSubtype.INVENTORY_REGIONAL;
import static org.gbif.api.model.vocabulary.DatasetSubtype.INVENTORY_THEMATIC;
import static org.gbif.api.model.vocabulary.DatasetSubtype.NOMENCLATOR_AUTHORITY;
import static org.gbif.api.model.vocabulary.DatasetSubtype.OBSERVATION;
import static org.gbif.api.model.vocabulary.DatasetSubtype.SPECIMEN;
import static org.gbif.api.model.vocabulary.DatasetSubtype.TAXONOMIC_AUTHORITY;

/**
 * Converter class for DatasetSubtype Enum using an immutable bimap for mapping key/values.
 */
public class DatasetSubtypeConverter extends BaseConverter<Integer, DatasetSubtype> {

  /**
   * @throws IllegalArgumentException if two keys have the same value
   */
  public DatasetSubtypeConverter() {
    super(null, new ImmutableMap.Builder<Integer, DatasetSubtype>()
      .put(18000, DERIVED_FROM_OCCURRENCE)
      .put(18010, GLOBAL_SPECIES_DATASET)
      .put(18020, INVENTORY_REGIONAL)
      .put(18030, INVENTORY_THEMATIC)
      .put(18040, NOMENCLATOR_AUTHORITY)
      .put(18050, OBSERVATION)
      .put(18060, SPECIMEN)
      .put(18070, TAXONOMIC_AUTHORITY)
      .build());
  };
}

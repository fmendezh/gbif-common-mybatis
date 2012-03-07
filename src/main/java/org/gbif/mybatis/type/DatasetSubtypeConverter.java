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
      .put(19000, DERIVED_FROM_OCCURRENCE)
      .put(19010, GLOBAL_SPECIES_DATASET)
      .put(19020, INVENTORY_REGIONAL)
      .put(19030, INVENTORY_THEMATIC)
      .put(19040, NOMENCLATOR_AUTHORITY)
      .put(19050, OBSERVATION)
      .put(19060, SPECIMEN)
      .put(19070, TAXONOMIC_AUTHORITY)
      .build());
  };
}

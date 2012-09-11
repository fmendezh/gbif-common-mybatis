package org.gbif.mybatis.type;


import org.gbif.api.vocabulary.IdentifierType;

/**
 * Mybatis type handler for TaxonomicStatus enumeration in ChecklistBank.
 */
public class IdentifierTypeTypeHandler extends BaseEnumTypeHandler<Integer, IdentifierType> {

  public IdentifierTypeTypeHandler() {
    super(new IdentifierTypeConverter());
  }
}

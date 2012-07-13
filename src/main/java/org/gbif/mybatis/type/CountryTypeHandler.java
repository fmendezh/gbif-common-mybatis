package org.gbif.mybatis.type;

import org.gbif.api.model.vocabulary.Country;


/**
 * MyBatis TypeHandler for {@link Country} enum.
 */
public class CountryTypeHandler extends BaseEnumTypeHandler<String, Country> {

  public CountryTypeHandler() {
    super(new CountryConverter());
  }

}

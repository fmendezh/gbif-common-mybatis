package org.gbif.mybatis.type;


import org.gbif.api.vocabulary.Country;

/**
 * Enum converter for {@link Country}.
 */
public class CountryConverter implements EnumConverter<String, Country> {

  @Override
  public String fromEnum(Country value) {
    return value.getIso2LetterCode();
  }

  @Override
  public Country toEnum(String key) {
    return Country.fromIsoCode(key);
  }

}

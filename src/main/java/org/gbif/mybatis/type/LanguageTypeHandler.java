package org.gbif.mybatis.type;


import org.gbif.api.vocabulary.Language;

/**
 * MyBatis type handler for {@link Language}.
 */
public class LanguageTypeHandler extends BaseEnumTypeHandler<String, Language> {

  public LanguageTypeHandler() {
    super(new LanguageConverter());
  }

}

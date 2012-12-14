package org.gbif.mybatis.type;


import org.gbif.api.vocabulary.Language;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link LanguageConverter}.
 */
public class LanguageConverterTest {

  LanguageConverter conv = new LanguageConverter();

  @Test
  public void testCompleteness() {
    for (Language t : Language.values()) {
      assertTrue(conv.fromEnum(t) != null);
    }
  }

  @Test
  public void testConversions() {
    assertEquals(Language.DANISH, conv.toEnum("DA"));
    assertEquals(Language.DANISH, conv.toEnum("da"));
    assertEquals(Language.ENGLISH, conv.toEnum("EN"));
    assertEquals(Language.SPANISH, conv.toEnum("ES"));
    assertEquals(Language.UNKNOWN, conv.toEnum("ZZ"));
    assertEquals(Language.UNKNOWN, conv.toEnum("nothing"));
    assertEquals(Language.UNKNOWN, conv.toEnum(""));
    assertEquals(Language.UNKNOWN, conv.toEnum(" "));
    assertEquals(Language.UNKNOWN, conv.toEnum(null));
  }
}

package org.gbif.mybatis.type;

import org.gbif.api.model.vocabulary.Country;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link LanguageConverter}.
 */
public class CountryConverterTest {

  private final CountryConverter conv = new CountryConverter();

  @Test
  public void testCompleteness() {
    for (Country t : Country.values()) {
      assertTrue(conv.fromEnum(t) != null);
    }
  }

  @Test
  public void testConversions() {
    assertEquals(Country.DENMARK, conv.toEnum("DK"));
    assertEquals(Country.DENMARK, conv.toEnum("dk"));
    assertEquals(Country.UNITED_STATES, conv.toEnum("US"));
    assertEquals(Country.UNITED_STATES, conv.toEnum("us"));
    assertEquals(Country.COSTA_RICA, conv.toEnum("CR"));
    assertEquals(Country.COSTA_RICA, conv.toEnum("cr"));
    assertEquals(Country.COSTA_RICA, conv.toEnum("CRI"));
    assertEquals(Country.COSTA_RICA, conv.toEnum("cri"));
  }
}

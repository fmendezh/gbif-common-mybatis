package org.gbif.mybatis.type;


import org.gbif.api.vocabulary.IdentifierType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IdentifierTypeConverterTest {

  @Test
  public void testCompleteness() {
    IdentifierTypeConverter conv = new IdentifierTypeConverter();

    for (IdentifierType t : IdentifierType.values()) {
      assertTrue(conv.fromEnum(t) >= 0);
    }
  }

  @Test
  public void testUnknown() {
    IdentifierTypeConverter conv = new IdentifierTypeConverter();

    assertEquals(IdentifierType.UNKNOWN, conv.toEnum(2008));
    assertEquals(IdentifierType.UNKNOWN, conv.toEnum(-473289));
    assertEquals(IdentifierType.UNKNOWN, conv.toEnum(null));

  }
}

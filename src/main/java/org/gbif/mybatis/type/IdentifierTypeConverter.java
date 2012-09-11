package org.gbif.mybatis.type;

import org.gbif.api.vocabulary.IdentifierType;

import com.google.common.collect.ImmutableMap;

import static org.gbif.api.vocabulary.IdentifierType.DOI;
import static org.gbif.api.vocabulary.IdentifierType.FTP;
import static org.gbif.api.vocabulary.IdentifierType.GBIF_PORTAL;
import static org.gbif.api.vocabulary.IdentifierType.GBIF_NODE;
import static org.gbif.api.vocabulary.IdentifierType.HANDLER;
import static org.gbif.api.vocabulary.IdentifierType.LSID;
import static org.gbif.api.vocabulary.IdentifierType.SOURCE_ID;
import static org.gbif.api.vocabulary.IdentifierType.UNKNOWN;
import static org.gbif.api.vocabulary.IdentifierType.URI;
import static org.gbif.api.vocabulary.IdentifierType.URL;
import static org.gbif.api.vocabulary.IdentifierType.UUID;

/**
 * EnumConverter for IdentifierType.
 */
public class IdentifierTypeConverter extends BaseConverter<Integer, IdentifierType> {

  public IdentifierTypeConverter() {
    super(UNKNOWN,
      new ImmutableMap.Builder<Integer, IdentifierType>().put(2000, URL).put(2001, LSID).put(2002, DOI)
        .put(2003, HANDLER).put(2004, UUID).put(2005, FTP).put(2006, URI).put(2007, SOURCE_ID).put(2008, UNKNOWN)
        .put(2009, GBIF_PORTAL).put(2012, GBIF_NODE).build());
  }
}

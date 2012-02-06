package org.gbif.mybatis.type;

import org.gbif.api.model.vocabulary.IdentifierType;

import com.google.common.collect.ImmutableMap;

import static org.gbif.api.model.vocabulary.IdentifierType.DOI;
import static org.gbif.api.model.vocabulary.IdentifierType.FTP;
import static org.gbif.api.model.vocabulary.IdentifierType.GBIF_PORTAL_DATA_PROVIDER_ID;
import static org.gbif.api.model.vocabulary.IdentifierType.GBIF_PORTAL_DATA_RESOURCE_ID;
import static org.gbif.api.model.vocabulary.IdentifierType.GBIF_PORTAL_NODE_ID;
import static org.gbif.api.model.vocabulary.IdentifierType.GBIF_PORTAL_RESOURCE_ACCESS_POINT_ID;
import static org.gbif.api.model.vocabulary.IdentifierType.HANDLER;
import static org.gbif.api.model.vocabulary.IdentifierType.LSID;
import static org.gbif.api.model.vocabulary.IdentifierType.SOURCE_ID;
import static org.gbif.api.model.vocabulary.IdentifierType.UNKNOWN;
import static org.gbif.api.model.vocabulary.IdentifierType.URI;
import static org.gbif.api.model.vocabulary.IdentifierType.URL;
import static org.gbif.api.model.vocabulary.IdentifierType.UUID;

/**
 * EnumConverter for IdentifierType.
 */
public class IdentifierTypeConverter extends BaseConverter<Integer, IdentifierType> {

  public IdentifierTypeConverter() {
    super(IdentifierType.UNKNOWN,
      new ImmutableMap.Builder<Integer, IdentifierType>().put(2000, URL).put(2001, LSID).put(2002, DOI)
        .put(2003, HANDLER).put(2004, UUID).put(2005, FTP).put(2006, URI).put(2007, SOURCE_ID).put(2008, UNKNOWN)
        .put(2009, GBIF_PORTAL_DATA_RESOURCE_ID).put(2010, GBIF_PORTAL_DATA_PROVIDER_ID)
        .put(2011, GBIF_PORTAL_RESOURCE_ACCESS_POINT_ID).put(2012, GBIF_PORTAL_NODE_ID).build());
  }
}

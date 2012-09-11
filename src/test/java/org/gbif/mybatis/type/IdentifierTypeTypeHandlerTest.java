package org.gbif.mybatis.type;

import org.gbif.api.exception.ServiceUnavailableException;
import org.gbif.api.vocabulary.IdentifierType;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IdentifierTypeTypeHandlerTest {

  @Mock
  private ResultSet mockedRs;
  private IdentifierTypeTypeHandler th = new IdentifierTypeTypeHandler();

  @Test
  public void testGetResult() throws ServiceUnavailableException {
    try {
      when(mockedRs.getObject("type")).thenReturn(2007);
      assertThat(th.getResult(mockedRs, "type"), is(IdentifierType.SOURCE_ID));
    } catch (SQLException e) {
    }
  }

  @Test
  public void testGetNull() throws ServiceUnavailableException {
    try {
      when(mockedRs.getObject("type")).thenReturn(null);
      assertThat(th.getResult(mockedRs, "type"), is(IdentifierType.UNKNOWN));
    } catch (SQLException e) {
    }
  }
}

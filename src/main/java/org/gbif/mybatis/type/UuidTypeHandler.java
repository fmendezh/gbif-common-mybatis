package org.gbif.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * Handler for UUID types.
 *
 * @see UUID
 */
public class UuidTypeHandler extends BaseTypeHandler<UUID> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
    ps.setString(i, parameter.toString());
  }

  @Override
  public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return toUuid(rs.getString(columnName));
  }

  @Override
  public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return toUuid(rs.getString(columnIndex));
  }

  @Override
  public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return toUuid(cs.getString(columnIndex));
  }

  /**
   * Converts a string to a {@link UUID} object if it is not null, returns {@code null otherwise}.
   *
   * @param val to convert into a UUID object, may be null
   * @return UUID object created from the val parameter
   */
  private static UUID toUuid(String val) {
    return val == null ? null : UUID.fromString(val);
  }

}

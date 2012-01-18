package org.gbif.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * Base handler for all Enums from the term_type table that are backed by the preferred terms of the term table.
 *
 * @param <T> the enumeration to be handled
 */
public class BaseEnumTypeHandler<T extends Enum<?>> implements TypeHandler<T> {

  private final BaseConverter<T> typeConverter;

  public BaseEnumTypeHandler(BaseConverter<T> typeConverter) {
    this.typeConverter = typeConverter;
  }

  @Override
  public void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
    ps.setObject(i, typeConverter.fromEnum((T) parameter));
  }

  @Override
  public T getResult(ResultSet rs, String columnName) throws SQLException {
    Integer termIndex = (Integer) rs.getObject(columnName);
    return typeConverter.toEnum(termIndex);
  }

  @Override
  public T getResult(CallableStatement cs, int columnIndex) throws SQLException {
    int termIndex = cs.getInt(columnIndex);
    return typeConverter.toEnum(termIndex);
  }
}

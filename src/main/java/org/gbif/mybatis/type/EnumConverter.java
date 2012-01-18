package org.gbif.mybatis.type;

/**
 * Generic CLB enumeration value converter interface for mapping magic clb integers used for persisting
 * to their respective enum values and vice versa.
 *
 * @param <T> the specific enumeration this converter is working with
 */
public interface EnumConverter<T extends Enum<?>> {

  /**
   * Converts an integer key used for persisting to the matching enumeration value.
   *
   * @param key the (term) id used for persisting
   *
   * @return the matching enumeration value or NULL if not found
   */
  T toEnum(Integer key);

  /**
   * Converts an enumeration value to its unique integer key used for persisting.
   *
   * @param value the enumeration value
   *
   * @return the matching (term) id used for persisting
   *
   * @throws IllegalArgumentException for unknown enumeration values
   */
  Integer fromEnum(T value);
}

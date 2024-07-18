package com.s_kugel.schneider.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * 社内ユーザーステータス
 *
 * @author schneider-code-generator
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum StaffStatus {

  /**
   * 無効
   */
  DISABLED("無効"),

  /**
   * 有効
   */
  ENABLED("有効");

  final String label;

  public static Optional<StaffStatus> fromCode(String code) {
    return Arrays.stream(values()).filter(v -> Objects.equals(v.name(), code)).findFirst();
  }

  public static Optional<StaffStatus> fromLabel(String label) {
    return Arrays.stream(values()).filter(v -> Objects.equals(v.label, label)).findFirst();
  }
}

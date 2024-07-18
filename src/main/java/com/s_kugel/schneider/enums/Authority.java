package com.s_kugel.schneider.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * 権限
 *
 * @author schneider-code-generator
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Authority {

  /**
   * ロール編集
   */
  EDIT_ROLE("ロール編集"),

  /**
   * 社内ユーザー編集
   */
  EDIT_STAFF("社内ユーザー編集"),

  /**
   * ロール閲覧
   */
  VIEW_ROLE("ロール閲覧"),

  /**
   * 社内ユーザー閲覧
   */
  VIEW_STAFF("社内ユーザー閲覧");

  final String label;

  public static Optional<Authority> fromCode(String code) {
    return Arrays.stream(values()).filter(v -> Objects.equals(v.name(), code)).findFirst();
  }

  public static Optional<Authority> fromLabel(String label) {
    return Arrays.stream(values()).filter(v -> Objects.equals(v.label, label)).findFirst();
  }
}

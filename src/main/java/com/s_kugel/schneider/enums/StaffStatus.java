package com.s_kugel.schneider.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StaffStatus {
  DISABLED("無効"), //
  ENABLED("有効");

  private final String label;
}

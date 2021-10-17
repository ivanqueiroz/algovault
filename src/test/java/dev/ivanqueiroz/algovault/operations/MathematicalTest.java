package dev.ivanqueiroz.algovault.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathematicalTest {

  @Test
  void get_nth_number_fibonacci() {
    final int i = Mathematical.getNthNumberFib(2);
    assertEquals(1, i);

    final int i2 = Mathematical.getNthNumberFib(4);
    assertEquals(3, i2);
  }
}

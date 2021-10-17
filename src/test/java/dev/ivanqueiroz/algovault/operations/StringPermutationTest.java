package dev.ivanqueiroz.algovault.operations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringPermutationTest {

  @Test
  void permutation() {
    final String word = "ivan";
    final List<String> output = StringPermutation.permutation(word);
    assertEquals(Mathematical.factorial(word.length()), output.size());
    assertTrue(output.contains("navi"));
  }
}

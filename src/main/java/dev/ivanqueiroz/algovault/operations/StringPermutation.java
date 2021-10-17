package dev.ivanqueiroz.algovault.operations;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StringPermutation {

  public static void main(String[] args) {
    StringPermutation.permutation("ivan");
  }

  public static List<String> permutation(String input) {
    List<String> output = new ArrayList<>();
    permutation("", input, output);
    return output;
  }

  private static void permutation(String perm, String word, List<String> output) {
    if (word.isBlank()) {
      output.add(perm + word);
    } else {
      for (int i = 0; i < word.length(); i++) {
        permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1), output);
      }
    }
  }

}

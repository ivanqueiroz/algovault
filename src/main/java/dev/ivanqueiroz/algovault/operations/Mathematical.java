package dev.ivanqueiroz.algovault.operations;

public class Mathematical {

  private Mathematical() {
    throw new IllegalArgumentException();
  }

  public static int factorial(int x) {
    if (x == 0) {
      return 1;
    } else {
      return x * factorial(x - 1);
    }
  }

  public static int getNthNumberFib(int x) {
    if (x == 0) {
      return 0;
    }

    if (x == 1) {
      return 1;
    }
    return getNthNumberFib(x - 1) + getNthNumberFib(x - 2);
  }


}

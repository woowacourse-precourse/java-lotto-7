package lotto.view;

public class OutputErrorView {

  public static void printError(IllegalArgumentException e) {
    System.out.println(e.getMessage());
  }
}

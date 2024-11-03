package lotto.utilities;

import java.util.List;

public class Splitter {
  private static final String DELIMITER = ",";

  public static List<String> splitWinningNumbers(String winningNumbers) {
    List<String> splitWinningNumbers = List.of(winningNumbers.split(DELIMITER));
    return splitWinningNumbers;
  }
}

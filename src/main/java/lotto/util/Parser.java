package lotto.util;

import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

  public static int parseInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw LottoException.throwInvalidFormatException();
    }
  }

  public static List<Integer> parseWinningNumbers(String input) {
    try {
      return Arrays.stream(input.split(","))
          .map(String::trim)
          .map(Parser::parseInt)
          .collect(Collectors.toList());
    } catch (NumberFormatException e) {
      throw LottoException.throwInvalidFormatException();
    }
  }
}

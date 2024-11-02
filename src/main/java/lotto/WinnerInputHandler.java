package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class WinnerInputHandler {
  private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 번호가 올바르지 않습니다. 다시 입력해 주시기 바랍니다.";
  private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
  private static final String SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다. 다시 입력해 주시기 바랍니다.";
  private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 중복되는 번호가 있습니다. 다시 입력해 주시기 바랍니다.";

  public List<Integer> getWinningNumber() {
    List<Integer> winningNumber;
    System.out.println(WINNING_NUMBER_MESSAGE);
    while (true) {
      String input = Console.readLine();
      winningNumber = validate(input);
      if (winningNumber != null) {
        break;
      }
    }
    return winningNumber;
  }

  private List<Integer> splitNumber(String input) {
    try {
      return Arrays.stream(input.split(","))
          .map(Integer::parseInt)
          .sorted()
          .toList();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
    }
  }

  private List<Integer> validate(String input) {
    try {
      List<Integer> list = splitNumber(input);
      HashSet<Integer> set = new HashSet<>(list);
      for (int number : list) {
        if (number < 1 || number > 45) {
          System.out.println(NUMBER_RANGE_ERROR_MESSAGE);
          return null;
        }
      }
      if (list.size() != 6) {
        System.out.println(SIZE_ERROR);
        return null;
      }
      if (set.size() != 6) {
        System.out.println(DUPLICATE_NUMBER_ERROR);
        return null;
      }
      return list;
    } catch (IllegalArgumentException e) {
      System.out.println(NUMBER_ERROR_MESSAGE);
      return null;
    }
  }
}
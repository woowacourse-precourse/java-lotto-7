package lotto;

import camp.nextstep.edu.missionutils.Console;

public class MoneyInputHandler {
  private static final String MONEY_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 구입금액이 올바르지 않습니다. 다시 입력해 주시기 바랍니다.";
  private static final String MONEY_RANGE_ERROR_MESSAGE = "[ERROR] 천원 이상이거나, 1000으로 나누어 떨어지는 금액으로 다시 입력해 주시기 바랍니다.";

  public int getMoney() {
    int myMoney = -1;
    System.out.println(MONEY_MESSAGE);
    while (true) {
      myMoney = validator(Console.readLine());
      if (myMoney > -1) {
        break;
      }
    }
    return myMoney;
  }

  private int validator(String input) {
    try {
      Integer.parseInt(input);
      validatePriceRange(input);
      return Integer.parseInt(input);
    } catch (IllegalArgumentException e) {
      System.out.println(NUMBER_ERROR_MESSAGE);
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    }
    return -1;
  }

  private void validatePriceRange(String input) {
    if (Integer.parseInt(input) % 1000 != 0 || Integer.parseInt(input) < 1000) {
      throw new ArithmeticException(MONEY_RANGE_ERROR_MESSAGE);
    }
  }
}
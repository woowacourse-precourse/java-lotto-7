package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

  private static final String REGEX = "^[0-9,]+$";
  private static final String DELIMITER = ",";

  public int inputPrice() {
      System.out.println("구입금액을 입력해 주세요.");
      return convertToNumber(Console.readLine());
  }

  public List<Integer> inputWinningNumbers() {
    System.out.println("\n당첨 번호를 입력해주세요.");
    return convertToNumbers(Console.readLine());
  }

  private List<Integer> convertToNumbers(String input) {
    if (!input.matches(REGEX)) {
      throw new IllegalArgumentException("[ERROR] 숫자와 쉼표(,)만 입력 가능합니다.");
    }
    return Arrays.stream(input.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }

  private int convertToNumber(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }
  }

  public int inputBonusNumber() {
    System.out.println("보너스 번호를 입력해주세요.");
    return convertToNumber(Console.readLine());
  }
}

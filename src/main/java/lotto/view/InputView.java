package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

// TODO 유용성 검사 기능 추가
// 1. 숫자인지 확인하는 유용성 검사 필요
// 2. amount 1000원 단윈인지 확인 필요 => InputView말고 LottoTransaction 에서 필요
public class InputView {
  static private final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
  static private final String WINNING_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요";
  static private final String BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요";

  public int requestPurchaseAmount() {
    printInputMessage(PURCHASE_AMOUNT_GUIDE);
    String amount = Console.readLine();

    return Integer.parseInt(amount);
  }

  // TODO 함수 분할하기 & 하드코딩 제거
  public List<Integer> requestWinningNumbers() {
    printInputMessage(WINNING_NUMBERS_GUIDE);

    List<Integer> numbers = new ArrayList<>();
    String input = Console.readLine();

    String[] inputNumbers = input.split(",");
    try {
      for (String numStr : inputNumbers) {

        int number = Integer.parseInt(numStr.trim()); // 공백 제거 후 정수로 변환
        numbers.add(number);

      }
    } catch (NumberFormatException e) {
      System.out.println("[ERROR] 숫자만 입력해주세요. ex)1,2,3,4,5,6");
    }
    return numbers;
  }

  public int requestBonusNumber() {
    printInputMessage(BONUS_NUMBER_GUIDE);
    String amount = Console.readLine();

    return Integer.parseInt(amount);
  }

  static private void printInputMessage(String message) {
    System.out.println(message);
  }
}

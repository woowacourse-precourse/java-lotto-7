package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    // 구입 금액 입력
    public int getPurchaseAmount() {
        String moneyAmount = Console.readLine();
        return Integer.parseInt(moneyAmount);
    }

    // 당첨 번호 입력
    public List<Integer> getWinningNumbers() {
        String winningNumbers = Console.readLine();
        return convertToList(winningNumbers);
    }

    // 보너스 번호 입력
    public int getBonusNumber() {
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    // 추후에 별로 파일로 분리 예정
    // String - to -> List<Integer>
    public static List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)  // 각 요소의 앞뒤 공백 제거
                .map(Integer::parseInt)  // String을 Integer로 변환
                .collect(Collectors.toList());  // List<Integer>로 수집
    }
}

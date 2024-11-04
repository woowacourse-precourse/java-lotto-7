package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class LottoInputView {
    public int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseNumbers(input);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseSingleNumber(input);
    }

    private List<Integer> parseNumbers(String input) {
        validateInput(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(num -> !num.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private int parseSingleNumber(String input) {
        validateInput(input);
        return Integer.parseInt(input.trim());
    }

    private void validateInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 비어 있을 수 없습니다.");
        }
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validateNumberInput(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();

        String[] numbers = validateNumbersInput(input);

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = Console.readLine();

        validateNumberInput(input);

        return Integer.parseInt(input);
    }

    private String[] validateNumbersInput(String input) {
         if (!isNumbers(input)) {
             throw new IllegalArgumentException("[ERROR] 6개 숫자를 콤마(, 또는 , )로 나열해야 합니다.");
         }
         return input.split("\\s*,\\s*");
    }

    private void validateNumberInput(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private boolean isNumber(String input) {
        return input.matches("^[0-9]+$");
    }

    private boolean isNumbers(String input) {
        return input.matches("^(\\d+\\s*,\\s*){5}\\d+$");
    }

}

package lotto.view;

import static lotto.util.PrintVariable.FIRST_BUY_MONEY_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.CustomStringUtils;

public class InputView {

    public Money inputMoney() {
        while (true) {
            try {
                CustomStringUtils.printStringLineFeed(FIRST_BUY_MONEY_INPUT.value());
                return Money.from(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputOwnLotto() {
        while (true) {
            try {
                CustomStringUtils.printStringLineFeed("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateLottoInput(input);

                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .toList();

                return Lotto.from(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateLottoInput(String input) {
        String[] inputNumbers = input.split(",");

        // 입력값이 숫자인지 체크
        if (Arrays.stream(inputNumbers).anyMatch(s -> !s.matches("[0-9]+"))) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                CustomStringUtils.printStringLineFeed("보너스 번호를 입력해 주세요.");
                String num = Console.readLine();

                if (!num.matches("[0-9]+")) {
                    throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
                }

                return Integer.parseInt(num);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

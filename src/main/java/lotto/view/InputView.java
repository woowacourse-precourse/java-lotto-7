package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

import java.util.Arrays;

public abstract class InputView {

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        checkIfPurchaseAmountIsValid(input);
        return Integer.parseInt(input);
    }

    public static Lotto readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        checkIfWinningLottoIsValid(input);
        return new Lotto(Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList());
    }

    public static Bonus readBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        checkIfBonusIsValid(input);
        return new Bonus(Integer.parseInt(input));
    }

    private static void checkIfBonusIsValid(String input) {
        isInputEmpty(input);
        isNumeric(input);
    }

    private static void checkIfPurchaseAmountIsValid(String input) {
        isInputEmpty(input);
        isNumeric(input);
    }

    private static void checkIfWinningLottoIsValid(String input) {
        isInputEmpty(input);
        isInputFormatValid(input);
        Arrays.stream(input.split(","))
                .forEach(value -> {
                    isInputEmpty(value);
                    isNumeric(value);
                });
    }

    private static void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
    }

    private static void isInputFormatValid(String input) {
        int inputLength = input.length();
        if (input.charAt(0) == ',' || input.charAt(inputLength - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력 형식입니다.");
        }
    }

    private static void isNumeric(String input) {
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
        }
    }
}

package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UserInput {
    private static final String SEPARATOR = ",";

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = Console.readLine().trim();
                validateEmptyInput(input);
                return LottoShop.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = Console.readLine().trim();
                validateEmptyInput(input);
                validateContainsSeparator(input);
                return new Lotto(Arrays.stream(input.split(SEPARATOR))
                        .map(UserInput::validateIsNumber)
                        .collect(Collectors.toCollection(ArrayList::new)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                String input = Console.readLine().trim();
                validateEmptyInput(input);
                return validateIsNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열은 입력할 수 없습니다");
        }
    }

    private void validateContainsSeparator(String input) {
        if (hasNotSeparator(input)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 포함해야 합니다");
        }
    }

    private static boolean hasNotSeparator(String input) {
        return !input.contains(SEPARATOR);
    }

    private static Integer validateIsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 숫자가 아닙니다");
        }
    }

}

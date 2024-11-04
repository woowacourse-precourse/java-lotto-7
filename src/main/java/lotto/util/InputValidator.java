package lotto.util;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public static void validatePurchasePrice(String input) {
        int price;
        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 정수여야 합니다.");
        }
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static void validateWinningNumbers(String input) {
        List<Integer> winningNumbers;
        if (input.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        try {
            winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 정수로 이루어져야 합니다.");
        }
        new Lotto(winningNumbers);
    }

    public static void validateBonusNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 보너스 번호는 정수로 이루어져야 합니다.");
        }
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

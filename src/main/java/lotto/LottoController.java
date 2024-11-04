package lotto;

import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    public static int parsePurchaseNumber(String input) {
        try {
            int purchaseNumber = Integer.parseInt(input.trim());
            Validator.validatePurchaseNumber(purchaseNumber);
            return purchaseNumber / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 구입금액 입니다.");
        }
    }

    public static List<Integer> parseWinNumber(String input) {
        try {
            List<Integer> numbers = Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            Validator.validateWinNumber(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 로또 번호입니다.");
        }
    }

    public static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 로또 번호입니다.");
        }
    }
}

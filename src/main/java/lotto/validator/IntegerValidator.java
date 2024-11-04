package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class IntegerValidator {
    private static final String INVALID_MONEY = "[ERROR] 정수로만 입력할 수 있습니다.";
    private static final String INVALID_LOTTO = "[ERROR] 로또 번호는 정수여야 합니다.";
    private static final String DELIMITER = ",";

    public static int moneyValidator(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }

    public static List<Integer> lottoValidator(String lotto) {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (String number : List.of(lotto.split(DELIMITER))) {
                numbers.add(Integer.parseInt(number));
            }
            return numbers;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO);
        }
    }
}
package lotto.model;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void lottoNumberValidate(String numbers) {
        List<String> checkNumbers = Arrays.stream(numbers.split(","))
                .toList();

        if (checkNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] "
                    + "당첨 번호는 공백 없이 "
                    + "쉼표(,) 기준으로 구분해 "
                    + "1 ~ 45인 숫자를 중복 없이 입력해야 합니다. "
                    + "ex)1,2,3,4,5,6");
        }

        for (String number : checkNumbers) {
            if (!number.matches("^(?:[1-9]|[1-3][0-9]|4[0-5])$")) {
                throw new IllegalArgumentException("[ERROR] "
                        + "당첨 번호는 공백 없이 "
                        + "쉼표(,) 기준으로 구분해 "
                        + "1 ~ 45인 숫자를 중복 없이 입력해야 합니다. "
                        + "ex)1,2,3,4,5,6");
            }
        }

        List<String> distinctList = checkNumbers.stream()
                .distinct()
                .toList();

        if (checkNumbers.size() != distinctList.size()) {
            throw new IllegalArgumentException("[ERROR] "
                    + "당첨 번호는 공백 없이 "
                    + "쉼표(,) 기준으로 구분해 "
                    + "1 ~ 45인 숫자를 중복 없이 입력해야 합니다. "
                    + "ex)1,2,3,4,5,6");
        }
    }

    public static void purchasePriceValidate(String money) {
        if (!money.matches("-?\\d+") || money.isBlank()) {
            throw new IllegalArgumentException("[ERROR] "
                    + "0 이상의 1000 단위로 나누어 떨어지는 숫자를 "
                    + "공백없이 입력해야합니다."
                    + " ex)8000");
        }

        int number = Integer.parseInt(money);
        if (number < 0 || (number % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] "
                    + "0 이상의 1000 단위로 나누어 떨어지는 숫자를 "
                    + "공백없이 입력해야합니다."
                    + " ex)8000");
        }
    }

    public static void bonusNumberValidate(String bonusNumber, List<Integer> numbers) {
        if (!bonusNumber.matches("-?\\d+") || bonusNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] "
                    + "보너스 점수는 1~45인 숫자를 공백 없이 입력 해야 합니다.");
        }

        int number = Integer.parseInt(bonusNumber);
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] "
                    + "보너스 점수는 1~45인 숫자를 공백 없이 입력 해야 합니다.");
        }

        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] "
                    + "당첨 번호와 중복 되지 않는 보너스 번호를 사용 해야 합니다.");
        }
    }
}

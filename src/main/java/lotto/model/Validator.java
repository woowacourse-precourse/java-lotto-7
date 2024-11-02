package lotto.model;

import java.util.List;

public class Validator {
    public static void lottoNumberValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int n : numbers) {
            if (!(n >= 1 && n <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 인 정수를 입력 해야 합니다.");
            }
        }

        List<Integer> distinctList = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 되는 로또 번호가 없어야 합니다.");
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

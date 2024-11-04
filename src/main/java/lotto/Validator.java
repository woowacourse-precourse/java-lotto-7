package lotto;

import java.util.List;

public class Validator {

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1,000원 단위로 입력해주세요.");
        }
        if (amount > 10000) {
            throw new IllegalArgumentException("[ERROR] 최대 구입 가능 금액은 10,000원 입니다.");
        }
    }

    public static void validateBonus(int bonus, List<String> winningNumbers) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(String.valueOf(bonus))){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (String number : winningNumbers) {
            validateWinningNumber(number);
        }
    }

    public static void validateWinningNumber(String number) {
        int num = Integer.parseInt(number);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
            }
        }
    }

}

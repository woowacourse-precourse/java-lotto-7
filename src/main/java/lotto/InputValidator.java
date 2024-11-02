package lotto;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public static List<Integer> validateWiningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

        //당첨 번호가 1 ~ 45 사이의 값이 아닐 때 (공통)
        for (int winningNumber : winningNumbers) {
            validateNumberRange(winningNumber);
        }
        //당첨 번호가 총 개수가 6개가 아닐 때
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 6개여야 합니다.");
        }

        return winningNumbers;
    }

    public static int validateBonusNumber(List<Integer> winningNumbers, String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        //보너스 번호가 당첨 번호 6개와 중복되는 수 일때
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호 6개와 중복 되지 않아야 합니다.");
        }
        //보너스 번호가 1 ~ 45 사이의 값이 아닐 때 (공통)
        validateNumberRange(bonusNumber);

        return bonusNumber;
    }

    public static int validateMoney(String inputMoney) {
        int money = isNumber(inputMoney);

        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 최소 1000원 이상이어야 합니다.");
        }
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위만 가능합니다.");
        }

        return money;
    }

    private static void validateNumberRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    static private int isNumber(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자 형식이 아닙니다.");
        }
    }
}

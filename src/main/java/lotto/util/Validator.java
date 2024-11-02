package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void validateAmountInput(String amountInput) {
        if (!amountInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        if (Integer.parseInt(amountInput) % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 단위는 1000원 단위 이상이어야 합니다.");
        }
    }

    public static void validateWinningLottoInput(String[] winningLottoInput) {
        if (winningLottoInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    public static void validateWinningLotto(List<Integer> winningLotto) {
        for (int lottoNumber : winningLotto) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45사이여야 합니다.");
            }
        }
    }

    public static List<Integer> convertWinningLottoInputToIntArray(String[] winningLottoInput) {
        List<Integer> winningLotto = new ArrayList<>();
        try {
            for (String eachWinningLottoNumber : winningLottoInput) {
                winningLotto.add(Integer.parseInt(eachWinningLottoNumber.trim()));
            }
            return winningLotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    public static int validateBonusNumberInput(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}

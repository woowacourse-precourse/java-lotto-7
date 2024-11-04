package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    private static final String ERROR_INVALID_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1000원 단위의 숫자로 입력해야 합니다.";
    private static final String ERROR_INVALID_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String ERROR_INVALID_WINNING_NUMBER = "[ERROR] 로또 번호들은 1부터 45 사이의 서로 중복되지 않는 숫자여야 합니다.";
    private static final String ERROR_INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_INVALID_LOTTO_NUMBER = "[ERROR] 로또 번호는 서로 중복되지 않는 1부터 45 사이의 숫자여야 합니다.";
    public static void isValidPurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+") || Integer.parseInt(purchaseAmount) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
        }
    }

    public static void isValidWinningNumbers(List<Integer> lottoWinningNumbers) {
        if (lottoWinningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_INVALID_WINNING_NUMBER_COUNT);
        }
    }

    public static void isValidWinningNumber(List<Integer> lottoWinningNumbers) {
        Set<Integer> checkNumbersAlreadyContain = new HashSet<>();
        for (Integer winningNumber : lottoWinningNumbers) {
            String lottoWinningNumber = Integer.toString(winningNumber);
            if (!lottoWinningNumber.matches("\\d+") || Integer.parseInt(lottoWinningNumber) > 45 || checkNumbersAlreadyContain.contains(Integer.parseInt(lottoWinningNumber))) {
                throw new IllegalArgumentException(ERROR_INVALID_WINNING_NUMBER);
            }
            checkNumbersAlreadyContain.add(winningNumber);
        }
    }

    public static void isValidBonusNumber(int bonusNumber, List<Integer> lottoWinningNumbers) {
        String lottoBonusNumber = Integer.toString(bonusNumber);
        if (!lottoBonusNumber.matches("\\d+") || Integer.parseInt(lottoBonusNumber) > 45 || lottoWinningNumbers.contains(Integer.parseInt(lottoBonusNumber))) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER);
        }
    }

    public static void isValidLottoNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER_COUNT);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER);
        }
        for(Integer number : numbers) {
            if(number<1 || number>45) {
                throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER);
            }
        }
    }
}

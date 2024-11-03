package lotto;

import java.util.List;

public class Validator {

    private final int WON = 1_000;
    private final String MONEY_ERROR_TEXT = "\"[ERROR] 구입 금액은 1,000원 단위로 구매 가능합니다.\"";

    public void validateLottoNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        boolean isValidRange = winningNumbers.stream().allMatch(num -> num >= 1 && num <= 45);
        if (!isValidRange) {
            throw new IllegalArgumentException("[ERROR] 각 번호는 1에서 45 사이여야 합니다.");
        }
    }

    public Integer validateMoney(String money) {
        int parsedMoney;

        try {
            parsedMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_ERROR_TEXT);
        }

        if (parsedMoney <= 0 || parsedMoney % WON != 0) {
            throw new IllegalArgumentException(MONEY_ERROR_TEXT);
        }

        return parsedMoney;
    }

    public boolean isValidWinningNumbers(List<Integer> numbers) {
        return numbers.size() == 6 &&
                numbers.stream().allMatch(num -> num >= 1 && num <= 45) &&
                numbers.stream().distinct().count() == numbers.size();
    }

    public boolean isValidBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        return bonusNumber >= 1 && bonusNumber <= 45 && !winningNumbers.contains(bonusNumber);
    }
}

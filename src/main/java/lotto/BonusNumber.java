package lotto;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(List<String> bonusNumbers, List<String> winningNumbers) {
        validateBonusNumber(bonusNumbers, winningNumbers);
        this.number = Integer.parseInt(bonusNumbers.get(0).trim()); // 첫 번째 요소를 보너스 번호로 설정
    }

    private static void validateBonusNumber(List<String> bonusNumbers, List<String> winningNumbers) {
        if (bonusNumbers.size() != 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }

        String bonus = bonusNumbers.get(0); // 첫 번째 요소를 가져옴

        if (isDuplicateBonus(bonus, winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }

        WinningLottoNumbers.validateNumber(bonus); // WinningLottoNumbers의 validateNumber 재사용
    }

    private static boolean isDuplicateBonus(String bonus, List<String> winningNumbers) {
        return winningNumbers.contains(bonus);
    }

    public int getNumber() {
        return number;
    }
}

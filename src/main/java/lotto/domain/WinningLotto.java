package lotto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final List<Integer> winningNumbers; // 당첨 번호 리스트
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateUniqueNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers); // 유효성 검사 추가
        this.winningNumbers = winningNumbers; // 당첨 번호 리스트 초기화
        this.bonusNumber = bonusNumber;
    }


    private static void validateBonusNumber(int bonusNumber, List<Integer> inputLottoNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        if (inputLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호에 중복된 숫자가 포함될 수 없습니다.");
            }
        }
    }

    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }


}

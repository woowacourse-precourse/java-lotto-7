package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber, numbers); // 유효성 검사 추가
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> inputLottoNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        if (inputLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}

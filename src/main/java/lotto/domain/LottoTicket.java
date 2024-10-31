package lotto.domain;

import java.util.List;

import lotto.util.messages.ErrorMessage;

public class LottoTicket extends Lotto {
    private final int bonusNumber;

    public LottoTicket(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        // 입력받은 보너스 번호가 1~45범위 안에 있는지 판별
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OVER_RANGE.getMessage());
        }
        // 입력받은 보너스 번호가 당첨번호에 이미 존재하는지 판별
        if (super.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    public List<Integer> getLottoNumbers() {
        return super.getLottoNumbers();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}

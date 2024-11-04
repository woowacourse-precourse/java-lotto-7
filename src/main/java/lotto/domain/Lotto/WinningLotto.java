package lotto.domain.Lotto;

import java.util.List;
import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoNumber;

public class WinningLotto {
    private static final String INVALID_DUPLICATED_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복된 번호를 입력할 수 없습니다.";
    private final Lotto winningLottoNum;
    private final LottoNumber bonusNum;

    public WinningLotto(Lotto winningLottoNum, LottoNumber bonusNum) {
        validateDuplicate(winningLottoNum, bonusNum);
        this.winningLottoNum = winningLottoNum;
        this.bonusNum = bonusNum;
    }

    private void validateDuplicate(Lotto winningLottoNum, LottoNumber bonusNum) {
        if (hasDuplicateBonusNumber(winningLottoNum, bonusNum)) {
            throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplicateBonusNumber(Lotto winningLottoNum, LottoNumber bonusNum) {
        return winningLottoNum.getLottoNumbers().stream()
                .anyMatch(number -> number.getValue() == bonusNum.getValue());
    }

    public List<LottoNumber> getWinningLottoNum() {
        return winningLottoNum.getLottoNumbers();
    }

    public int getBonusNum() {
        return bonusNum.getValue();
    }
}

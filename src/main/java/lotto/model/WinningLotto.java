package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLottoNum;
    private final Number bonusNum;

    public WinningLotto(Lotto winningLottoNum, Number bonusNum) {
        validateDuplicate(winningLottoNum, bonusNum);
        this.winningLottoNum = winningLottoNum;
        this.bonusNum = bonusNum;
    }

    private void validateDuplicate(Lotto winningLottoNum, Number bonusNum) {
        if (hasDuplicateBonusNumber(winningLottoNum, bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호를 입력할 수 없습니다.");
        }
    }

    private boolean hasDuplicateBonusNumber(Lotto winningLottoNum, Number bonusNum) {
        return winningLottoNum.getLottoNumbers().stream()
                .anyMatch(number -> number.getValue() == bonusNum.getValue());
    }

    public List<Number> getWinningLottoNum() {
        return winningLottoNum.getLottoNumbers();
    }

    public int getBonusNum() {
        return bonusNum.getValue();
    }
}

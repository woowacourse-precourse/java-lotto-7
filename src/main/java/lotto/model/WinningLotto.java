package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final List<Number> winningLotto;

    public WinningLotto(Lotto winningLottoNum, Number bonusNum) {
        validateDuplicate(winningLottoNum, bonusNum);
        this.winningLotto = combineLottoNumber(winningLottoNum, bonusNum);
    }

    private void validateDuplicate(Lotto winningLottoNum, Number bonusNum) {
        if (hasDuplicateBonusNumber(winningLottoNum, bonusNum)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호를 입력할 수 없습니다.");
        }
    }

    private boolean hasDuplicateBonusNumber(Lotto winningLottoNum, Number bonusNum) {
        return winningLottoNum.getNumbers().stream()
                .anyMatch(number -> number.getValue() == bonusNum.getValue());
    }

    private List<Number> combineLottoNumber(Lotto winningLottoNum, Number bonusNum) {
        List<Number> combinedList = new ArrayList<>(winningLottoNum.getNumbers());
        combinedList.add(bonusNum);
        return combinedList;
    }

    public List<Number> getWinningLotto() {
        return winningLotto;
    }
}

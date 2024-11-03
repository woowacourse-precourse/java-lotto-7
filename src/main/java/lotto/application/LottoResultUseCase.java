package lotto.application;

import java.util.List;

public interface LottoResultUseCase {

    void createWinLotto(List<Integer> numbers, int bonusNumber);

    void checkWinning();
}

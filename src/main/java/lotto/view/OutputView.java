package lotto.view;

import lotto.dto.LottosDto;
import lotto.dto.ScoreDto;

public interface OutputView {

    void printBoughtLottos(LottosDto lottosDto);

    void printScoreResult(ScoreDto scoreDto);
}

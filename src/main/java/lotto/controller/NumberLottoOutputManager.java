package lotto.controller;

import lotto.dto.LottosDto;
import lotto.dto.ScoreDto;
import lotto.view.OutputView;

public class NumberLottoOutputManager {

    private final OutputView outputView;

    public NumberLottoOutputManager(OutputView outputView) {
        this.outputView = outputView;
    }


    public void printLottos(LottosDto lottosDto) {
        outputView.printBoughtLottos(lottosDto);
    }

    public void printScoreResult(ScoreDto ScoreDto, int numberOfLottoPurchased) {

    }
}

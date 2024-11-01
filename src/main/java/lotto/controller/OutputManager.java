package lotto.controller;

import lotto.constants.collection.ScoreSystemReward;
import lotto.constants.value.LottoRule;
import lotto.dto.LottosDto;
import lotto.dto.ScoreDto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OutputManager {

    private final OutputView outputView;

    public OutputManager(OutputView outputView) {
        this.outputView = outputView;
    }


    public void printLottos(LottosDto lottosDto) {
        outputView.printBoughtLottos(lottosDto);
    }

    public void printScoreResult(ScoreDto scoreDto, int numberOfLottoPurchased) {
        List<Integer> scoreValues = new ArrayList<>(scoreDto.score().values());
        int totalUsedPrice = LottoRule.LOTTO_PRICE.getInstance();
        List<Integer> scoreSystemReward = ScoreSystemReward.DEFAULT.getInstance();
        int totalSum = IntStream.range(0, scoreValues.size())
                .map(i -> scoreValues.get(i) * scoreSystemReward.get(i))
                .sum();
        float totalReturn = (float) totalSum / totalUsedPrice;
        outputView.printScoreResult(scoreValues,totalReturn);
    }
}

package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Cost;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoRankDto;
import lotto.view.LottoGameView;

public class LottoGameController {

    private final LottoGameView lottoGameView;

    public LottoGameController(LottoGameView lottoGameView) {
        this.lottoGameView = lottoGameView;
    }

    public void playGame() {
        Cost cost = requestCost();
        Lottos lottos = generateLottos(cost);

        WinningLotto winningLotto = requestWinningLotto();
        LottoResult lottoResult = lottos.calculateResult(winningLotto);

        displayResult(lottoResult, cost);
    }

    private Cost requestCost() {
        return new Cost(lottoGameView.requestCost());
    }

    private Lottos generateLottos(Cost cost) {
        int lottoAmount = cost.calculateLottoAmount();
        Lottos lottos = LottoGenerator.generateLottos(lottoAmount);

        lottoGameView.displayLottoAmount(lottoAmount);
        lottoGameView.displayLottos(lottos);
        return lottos;
    }

    private WinningLotto requestWinningLotto() {
        List<Integer> winningNumbers = lottoGameView.requestWinningLotto();
        int bonusNumber = lottoGameView.requestBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void displayResult(LottoResult lottoResult, Cost cost) {
        Map<LottoRank, Long> lottoRankLongMap = lottoResult.calculateStatistics();

        List<LottoRankDto> lottoRankDto = Arrays.stream(LottoRank.values())
                .map(it -> LottoRankDto.from(it, lottoRankLongMap.getOrDefault(it, 0L)))
                .collect(Collectors.toList());

        lottoGameView.displayStatistics(lottoRankDto);
        lottoGameView.displayProfit(lottoResult.calculateProfit(cost));
    }
}

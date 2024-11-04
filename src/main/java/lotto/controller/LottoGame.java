package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.view.InputView.LOTTO_PRICE;

public class LottoGame {

    private final InputView inputView;
    private final LottoManager lottoManager;
    private final OutputView outputView;

    public LottoGame(InputView inputView, LottoManager lottoManager, OutputView outputView) {
        this.inputView = inputView;
        this.lottoManager = lottoManager;
        this.outputView = outputView;
    }

    public void start() {
        int lottoCount = purchaseLotto();
        List<Lotto> lottoSets = generateLottoNumbers(lottoCount);
        Lotto winningNumbers = setUpWinningNumbers();
        int bonusNumber = setUpBonusNumber(winningNumbers);
        Map<LottoRank,Long> lottoRankResults = processLottoResults(lottoSets, winningNumbers, bonusNumber);
        calculateReturnRate(lottoRankResults,lottoCount);
    }

    private void calculateReturnRate(Map<LottoRank, Long> lottoRankResults, int lottoCount) {
        String returnRate = lottoManager.getReturnRate(lottoRankResults, lottoCount*LOTTO_PRICE);
        outputView.displayReturnRate(returnRate);
    }

    private Map<LottoRank,Long> processLottoResults(List<Lotto> lottoSets, Lotto winningNumbers, int bonusNumber) {
        Map<LottoRank, Long> lottoRankResults = lottoManager.analyzeLottoResults(lottoSets, winningNumbers, bonusNumber);
        outputView.displayWinningResults(lottoRankResults);
        return lottoRankResults;
    }

    private int setUpBonusNumber(Lotto winningNumbers) {
        outputView.requestBonusLottoNumbers();
        return inputView.getBonusLottoNumber(winningNumbers);
    }

    private Lotto setUpWinningNumbers() {
        outputView.requestWinningLottoNumbers();
        return lottoManager.parseWinningNumbersToLotto(inputView.getWinningNumbers());
    }

    private List<Lotto> generateLottoNumbers(int lottoCount) {
        List<Lotto> lottoSets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoSets.add(lottoManager.generateLottoNumbers());
        }
        outputView.displayLottoPurchaseResult(lottoSets);
        return lottoSets;
    }

    private int purchaseLotto() {
        outputView.requestLottoPrice();
        return inputView.getLottoPrice();
    }


}

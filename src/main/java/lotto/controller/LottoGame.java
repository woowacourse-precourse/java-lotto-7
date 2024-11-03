package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<Lotto>lottoSets = lottoGenerator(lottoCount);
        Lotto winningNumbers = setUpWinningNumbers();
        int bonusNumber = setUpBonusNumber(winningNumbers);
        processLottoResults(lottoSets,winningNumbers,bonusNumber);

    }

    private void processLottoResults(List<Lotto> lottoSets, Lotto winningNumbers, int bonusNumber) {
        Map<LottoRank, Long> lottoRankResults = lottoManager.analyzeLottoResults(lottoSets, winningNumbers, bonusNumber);
        outputView.displayWinningResults(lottoRankResults);
    }

    private int setUpBonusNumber(Lotto winningNumbers) {
        outputView.requestBonusLottoNumbers();
        return inputView.getBonusLottoNumber(winningNumbers);
    }

    private Lotto setUpWinningNumbers() {
        outputView.requestWinningLottoNumbers();
        return lottoManager.parseWinningNumbersToLotto(inputView.getWinningNumbers());
    }

    private List<Lotto>lottoGenerator(int lottoCount) {
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

package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final Parser parser;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
        this.parser = parser;
    }

    public void run() {
        int purchaseAmount = parser.purchaseAmountParser(inputView.readPurchaseAmount());
        lottoMachine.initMachine();
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);
        outputView.printIssuedLottos(lottos);

        List<Integer> winningNums = parser.winningNumsParser(inputView.readWinningNums());
        lottoMachine.updateWinningNums(winningNums);
        int bonusNum = parser.bonusNumParser(inputView.readBonusNum());
        lottoMachine.updateBonusNum(bonusNum);

        lottoMachine.updateWinningDetail(lottos);
        Map<String, Integer> winningDetail = lottoMachine.getWinningDetail();
        outputView.printWinningDetail(winningDetail);
        double profitRate = lottoMachine.getProfitRate(purchaseAmount);
    }
}

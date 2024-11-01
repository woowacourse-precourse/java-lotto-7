package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.util.Parser;
import lotto.view.InputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private final Parser parser;

    public LottoController(InputView inputView, LottoMachine lottoMachine, Parser parser) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.parser = parser;
    }

    public void run() {
        int purchaseAmount = parser.purchaseAmountParser(inputView.readPurchaseAmount());
        lottoMachine.initMachine();
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);
        List<Integer> winningNums = parser.winningNumsParser(inputView.readWinningNums());
        lottoMachine.updateWinningNums(winningNums);
        int bonusNum = parser.bonusNumParser(inputView.readBonusNum());
        lottoMachine.updateBonusNum(bonusNum);
        lottoMachine.updateWinningDetail(lottos);
        Map<String, Integer> winningDetail = lottoMachine.getWinningDetail();
    }
}

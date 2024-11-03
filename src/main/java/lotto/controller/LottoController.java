package lotto.controller;

import lotto.LottoMatchState;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.util.Parser;
import lotto.view.ViewFacade;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final ViewFacade viewFacade;
    private final LottoMachine lottoMachine;
    private final Parser parser;

    public LottoController(ViewFacade viewFacade, LottoMachine lottoMachine, Parser parser) {
        this.viewFacade = viewFacade;
        this.lottoMachine = lottoMachine;
        this.parser = parser;
    }

    public void run() {
        int purchaseAmount = parser.purchaseAmountParser(viewFacade.readPurchaseAmount());
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);
        viewFacade.printIssuedLottos(lottos);

        List<Integer> winningNums = parser.winningNumsParser(viewFacade.readWinningNums());
        lottoMachine.updateWinningNums(winningNums);
        int bonusNum = parser.bonusNumParser(viewFacade.readBonusNum());
        lottoMachine.updateBonusNum(bonusNum);

        lottoMachine.updateWinningDetail(lottos);
        Map<LottoMatchState, Integer> winningDetail = lottoMachine.getWinningDetail();
        viewFacade.printWinningDetail(winningDetail);
        double profitRate = lottoMachine.getProfitRate(purchaseAmount);
        viewFacade.printProfitRate(profitRate);
    }
}

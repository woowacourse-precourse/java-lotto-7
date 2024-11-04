package lotto.controller;

import lotto.model.LottoMatchState;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.util.Parser;
import lotto.view.ViewFacade;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final ViewFacade viewFacade;
    private final LottoMachine lottoMachine;

    public LottoController(ViewFacade viewFacade, LottoMachine lottoMachine) {
        this.viewFacade = viewFacade;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        int purchaseAmount = Parser.purchaseAmountParser(viewFacade.readPurchaseAmount());
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);
        viewFacade.printIssuedLottos(lottos);

        List<Integer> winningNums = Parser.winningNumsParser(viewFacade.readWinningNums());
        lottoMachine.updateWinningNums(winningNums);
        int bonusNum = Parser.bonusNumParser(viewFacade.readBonusNum());
        lottoMachine.updateBonusNum(bonusNum);

        lottoMachine.updateWinningDetail(lottos);
        Map<LottoMatchState, Integer> winningDetail = lottoMachine.getWinningDetail();
        viewFacade.printWinningDetail(winningDetail);
        double profitRate = lottoMachine.getProfitRate(purchaseAmount);
        viewFacade.printProfitRate(profitRate);
    }
}

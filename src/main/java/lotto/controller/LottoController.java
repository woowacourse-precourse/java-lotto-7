package lotto.controller;

import lotto.Validator;
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
    private final Validator validator;

    public LottoController(ViewFacade viewFacade, LottoMachine lottoMachine, Validator validator) {
        this.viewFacade = viewFacade;
        this.lottoMachine = lottoMachine;
        this.validator = validator;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);
        viewFacade.printIssuedLottos(lottos);

        List<Integer> winningNums = getWinningNums();
        lottoMachine.updateWinningNums(winningNums);
        int bonusNum = getBonusNum();
        lottoMachine.updateBonusNum(bonusNum);

        lottoMachine.updateWinningDetail(lottos);
        Map<LottoMatchState, Integer> winningDetail = lottoMachine.getWinningDetail();
        viewFacade.printWinningDetail(winningDetail);
        double profitRate = lottoMachine.getProfitRate(purchaseAmount);
        viewFacade.printProfitRate(profitRate);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = Parser.purchaseAmountParser(viewFacade.readPurchaseAmount());
                validator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private List<Integer> getWinningNums() {
        while (true) {
            try {
                List<Integer> winningNums = Parser.winningNumsParser(viewFacade.readWinningNums());
                validator.validateWinningNum(winningNums);
                return winningNums;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private int getBonusNum() {
        while (true) {
            try {
                int bonusNum = Parser.bonusNumParser(viewFacade.readBonusNum());
                validator.validateBonusNum(bonusNum);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}

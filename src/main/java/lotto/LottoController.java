package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoView view;
    private LottoLogic logic;

    public LottoController(LottoView view, LottoLogic logic) {
        this.view = view;
        this.logic = logic;
    }

    public void run() {
        buyLottos();
        Map<LottoEnum, Integer> matchResult = matchWinningLotto();
        double benefit = logic.calculateBenefit();
        view.printFinalStatus(matchResult, benefit);
    }

    private void buyLottos() {
        while (true) {
            try {
                int purchaseAmount = view.readPurchaseAmount();
                List<Lotto> lottos = logic.issueLottoAsPrice(purchaseAmount);

                int purchaseCount = logic.getTicketCount(purchaseAmount);
                view.printIssuedLottos(purchaseCount, lottos);

                break;
            } catch (IllegalArgumentException iae) {
                view.printErrorMessage(iae.getMessage());
            }
        }
    }

    private Map<LottoEnum, Integer> matchWinningLotto() {
        ValidationForm<List<Integer>> winningNumbersValidated = getWinningNumbersValidated();
        ValidationForm<Integer> bonusNumberValidated = getBonusNumberValidated();

        return logic.matchWinners(winningNumbersValidated, bonusNumberValidated);
    }

    private ValidationForm<List<Integer>> getWinningNumbersValidated() {
        while (true) {
            try {
                List<Integer> winningNumbers = view.readWinningNumbers();
                return logic.validateWinningNumber(winningNumbers);
            } catch (IllegalArgumentException iae) {
                view.printErrorMessage(iae.getMessage());
            }

        } 
    }

    private ValidationForm<Integer> getBonusNumberValidated() {
        while (true) {
            try {
                int bonusNumber = view.readBonusNumber();
                return logic.validateBonusNumber(bonusNumber);
            } catch (IllegalArgumentException iae) {
                view.printErrorMessage(iae.getMessage());
            }

        } 
    }

    
}

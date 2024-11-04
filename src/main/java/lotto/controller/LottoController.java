package lotto.controller;

import lotto.constants.lottoType.LottoType;
import lotto.model.Customer;
import lotto.model.LottoHandler;
import lotto.model.Lottos;
import lotto.model.RankingHandler;
import lotto.utils.BonusNumberValidation;
import lotto.utils.LottoPurchaseValidation;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class LottoController {

    private final Customer customer = new Customer();
    private final LottoHandler lottoHandler;
    private final RankingHandler rankingHandler;

    public LottoController(LottoHandler lottoHandler, RankingHandler rankingHandler) {
        this.lottoHandler = lottoHandler;
        this.rankingHandler = rankingHandler;
    }

    public void start() {
        try {
            purchaseLotto();
            winningNumbers();
            bonusNumber();
            winningStatistics();
            winningsYield();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void purchaseLotto() {
        String rawClientMoney = InputMessage.inputClientMoney();
        int clientMoney = LottoPurchaseValidation.checkedClientMoney(rawClientMoney);

        customer.buyLottoTickets(clientMoney);
        lottoHandler.buyLottos(customer.getLottoTickets());

        OutputMessage.buyLottoCount(customer.getLottoTickets());
        OutputMessage.buyLottoResults(lottoHandler.getLottoList());
    }

    private void winningNumbers() {
        String rawWinningNumbers = InputMessage.inputWinningNumbers();
        lottoHandler.inputWinningLottoNumbers(rawWinningNumbers);
    }

    private void bonusNumber() {
        String rawBonusNumber = InputMessage.inputBonusNumber();
        int bonusNumber = BonusNumberValidation.checkedBonusNumber(rawBonusNumber);
        BonusNumberValidation.validateBonusNumber(bonusNumber, lottoHandler.getWinningLottoNumbers());

        lottoHandler.setBonusNumber(bonusNumber);
    }

    private void winningStatistics() {
        OutputMessage.winningStatistics();
        lottoHandler.staticsResults(customer);
        rankingHandler.printResults(customer);
    }

    private void winningsYield() {
        double value = customer.getWinningsYield(customer.getLottoTickets() * LottoType.LOTTO_PRICE.getValue());
        OutputMessage.winningsYield(value);
    }

}

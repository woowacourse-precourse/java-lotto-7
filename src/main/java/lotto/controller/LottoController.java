package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoHandler;
import lotto.model.RankingHandler;
import lotto.utils.BonusNumberValidation;
import lotto.utils.LottoPurchaseValidation;
import lotto.utils.WinningNumberValidation;
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
        purchaseLotto();
        inputWinningNumbers();
        inputBonusNumber();
        outputWinningStatistics();
        testMethod();
    }

    private void purchaseLotto() {
        String rawClientMoney = InputMessage.inputClientMoney();
        int clientMoney = LottoPurchaseValidation.checkedClientMoney(rawClientMoney);

        customer.buyLottoTickets(clientMoney);
        lottoHandler.buyLottos(customer.getLottoTickets());

        OutputMessage.buyLottoCount(customer.getLottoTickets());
        OutputMessage.buyLottoResults(lottoHandler.getLottoList());
    }

    private void inputWinningNumbers() {
        String rawWinningNumbers = InputMessage.inputWinningNumbers();
        lottoHandler.inputWinningLottoNumbers(rawWinningNumbers);
    }

    private void inputBonusNumber() {
        String rawBonusNumber = InputMessage.inputBonusNumber();
        int bonusNumber = BonusNumberValidation.checkedBonusNumber(rawBonusNumber);
        BonusNumberValidation.validateBonusNumber(bonusNumber, lottoHandler.getWinningLottoNumbers());

        lottoHandler.setBonusNumber(bonusNumber);
    }

    private void outputWinningStatistics() {
        OutputMessage.winningStatistics();
        lottoHandler.staticsResults(customer);
        rankingHandler.printResults(customer);

    }

    private void testMethod() {
        double value = customer.getWinningsYield(customer.getLottoTickets() * 1000);
        System.out.printf("총 수익률은 %.1f%%입니다.", value);
    }


}

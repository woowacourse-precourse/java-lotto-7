package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoHandler;
import lotto.model.RankingHandler;
import lotto.utils.LottoPurchaseValidation;
import lotto.view.InputMessage;

public class LottoController {

    private final Customer customer = new Customer();
    private final LottoHandler lottoHandler;
    private final RankingHandler rankingHandler;
    private Lotto lotto;

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
        System.out.println(lottoHandler.getLottoList());
    }

    private void inputWinningNumbers() {
        String rawWinningNumbers = Console.readLine();
        lottoHandler.inputWinningLottoNumbers(rawWinningNumbers);
        System.out.println(lottoHandler.getWinningLottoNumbers().getNumbers());
    }

    private void inputBonusNumber() {
        int rawBonusNumbers = Integer.parseInt(Console.readLine());
        lottoHandler.setBonusNumber(rawBonusNumbers);
        System.out.println(lottoHandler.getBonusNumber());
    }

    private void outputWinningStatistics() {
        lottoHandler.staticsResults(customer);
        rankingHandler.printResults(customer);

    }

    private void testMethod() {
        double value = customer.getWinningsYield(customer.getLottoTickets() * 1000);
        System.out.printf("총 수익률은 %.1f%% 입니다.", value);
    }


}

package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoHandler;
import lotto.model.RankingHandler;

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
    }

    private void purchaseLotto() {
        int rawInputMoney = Integer.parseInt(Console.readLine());
//        customer = new Customer();
        customer.buyLottoTickets(rawInputMoney);
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




}

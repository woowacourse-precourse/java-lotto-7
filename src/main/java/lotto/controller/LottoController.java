package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.controller.manager.InputManager;
import lotto.model.LottoRank;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final LottoService service;
    private final InputManager manager;

    public LottoController(View view, LottoService service) {
        this.view = view;
        this.service = service;
        this.manager = new InputManager(this.view);
    }

    public void run(User user) {

        buyTickets(user);
        setupWinningNumbers();
        printResults(user);
    }

    private void buyTickets(User user) {
        int money = manager.getMoney();
        int ticketCount = service.convertMoneyToTickets(money);
        view.printPurchaseMessage(ticketCount);
        service.provideLottoTickets(user, ticketCount);
        view.printLottoNumbers(user.getLottoTickets());
    }

    private void setupWinningNumbers() {
        List<Integer> winningNumbers = manager.getWinningNumbers(); // 당첨 번호 입력
        int bonusNumber = manager.getBonusNumber(winningNumbers);   // 보너스 번호 입력

        service.setWinningNumbers(winningNumbers, bonusNumber);     // 서비스에 당첨 번호와 보너스 번호 설정
    }

    private void printResults(User user) {
        Map<LottoRank, Integer> results = service.calculateResults();
        int totalSpent = service.calculateTotalSpent(user); // 로또 티켓 구매 비용 계산
        double profitRate = service.calculateProfitRate(results, totalSpent);
        view.displayResults(results, profitRate);
    }
}

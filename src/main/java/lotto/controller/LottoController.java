package lotto.controller;

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
        try {
            buyTickets(user);
            setupWinningNumbers();
            printResults(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // 프로그램 종료 또는 다른 오류 처리 로직
        }
    }

    private void buyTickets(User user) {
        int money = manager.getMoney();
        int ticketCount = service.convertMoneyToTickets(money);
        view.printPurchaseMessage(ticketCount);
        service.provideLottoTickets(user, ticketCount);
        view.printLottoNumbers(user.getLottoTickets());
    }

    private void setupWinningNumbers() {
        service.setWinningNumbers(manager.getWinningNumbers(), manager.getBonusNumber());
    }

    private void printResults(User user) {
        Map<LottoRank, Integer> results = service.calculateResults();
        int totalSpent = service.calculateTotalSpent(user); // 로또 티켓 구매 비용 계산
        double profitRate = service.calculateProfitRate(results, totalSpent);
        view.displayResults(results, profitRate);
    }
}

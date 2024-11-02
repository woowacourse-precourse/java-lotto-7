package lotto.presentation.controller;


import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import lotto.domain.model.PrizeCategory;
import lotto.domain.service.LottoPurchaseService;
import lotto.domain.service.LottoStatisticsService;
import java.util.List;
import lotto.presentation.view.LottoOutputView;
import lotto.presentation.view.LottoInputView;


//로또 게임을 제어하는 클래스
public class LottoController {
    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();
    private final LottoPurchaseService purchaseService = new LottoPurchaseService();
    private final LottoStatisticsService statisticsService = new LottoStatisticsService();

    public void run() {
        int purchaseAmount = getValidPurchaseAmount(); // 유효한 금액이 입력될 때까지 반복

        // 로또 티켓 구매
        List<Lotto> tickets = purchaseService.purchaseTickets(purchaseAmount);
        outputView.displayPurchasedTickets(tickets);

        // 당첨 번호 입력
        WinningNumbers winningNumbers = getValidWinningNumbers(); // 유효한 입력이 올 때까지 반복

        // 통계 및 결과 계산
        int[] prizeCounts = statisticsService.calculatePrizeCounts(tickets, winningNumbers);
        int totalPrize = statisticsService.calculateTotalPrize(prizeCounts);
        double profitRate = statisticsService.calculateProfitRate(purchaseAmount, totalPrize);

        // 결과 출력
        outputView.displayWinningStatistics(List.of(PrizeCategory.values()), prizeCounts);
        outputView.displayTotalProfitRate(profitRate);
    }

    //예외 처리 빼기 !!

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                return inputView.getPurchaseAmount(); // 유효한 금액이 입력될 때까지 반복
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage()); // 예외 메시지 출력
            }
        }
    }

    private WinningNumbers getValidWinningNumbers() {
        while (true) {
            try {
                return inputView.getWinningNumbers(); // 유효한 입력이 올 때까지 반복
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage()); // 예외 메시지 출력
            }
        }
    }
}
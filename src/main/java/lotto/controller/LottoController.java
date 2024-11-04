package lotto.controller;

import lotto.model.Prize;
import lotto.service.LottoService;
import lotto.service.PrizeCalculator;
import lotto.model.WinningNumbers;
import lotto.model.Lotto;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final PrizeCalculator prizeCalculator;

    public LottoController(LottoService lottoService, PrizeCalculator prizeCalculator){
        this.lottoService = lottoService;
        this.prizeCalculator = prizeCalculator;
    }

    public void start(){
        int purchaseAmount = lottoService.inputPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.generateLottoNumbers(purchaseAmount);
        printLottoTickets(lottoTickets);
        WinningNumbers winningNumbers = lottoService.inputWinningNumbers();
        prizeCalculator.checkWinningNumbers(winningNumbers, lottoTickets);
        printWinningStatistics(purchaseAmount);
    }

    private void printLottoTickets(List<Lotto> lottoTickets){
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets){
            System.out.println(lotto);
        }
    }

    private void printWinningStatistics(int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            int count = prizeCalculator.getPrizeCountMap().getOrDefault(prize, 0);
            StringBuilder prizeMessage = new StringBuilder();

            prizeMessage.append(prize.getMatchCount()).append("개 일치");

            if (prize == Prize.FIVE_MATCH_BONUS) {
                prizeMessage.append(", 보너스 볼 일치");
            }

            prizeMessage.append(String.format(" (%,d원) - %d개", prize.getPrizeAmount(), count));
            System.out.println(prizeMessage);
        }

        double yield = prizeCalculator.calculateYield(purchaseAmount * 1000); //개수 * 1000 = 금액
        System.out.printf("총 수익률은 %.1f%%입니다.\n", Math.round(yield * 10) / 10.0);

    }

}

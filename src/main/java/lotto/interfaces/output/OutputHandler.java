package lotto.interfaces.output;

import lotto.interfaces.prize.LottoResultResponse;
import lotto.interfaces.ticket.LottoTicketResponse;

public class OutputHandler {

    public void printPurchasedLotto(LottoTicketResponse lottoTicketResponse) {
        System.out.println(lottoTicketResponse.lottoCount() + "개를 구매했습니다.");
        lottoTicketResponse.lottos().forEach(System.out::println);
        printNewLine();
    }

    public void printLottoResult(LottoResultResponse lottoResultResponse) {
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoResultResponse.lottoPrizes()
                .forEach(lottoPrize -> {
                    System.out.print(lottoPrize.matchCount() + "개 일치");
                    if (lottoPrize.isBonusNumberRequired()) {
                        System.out.print(", 보너스 볼 일치");
                    }
                    System.out.println(" (" + String.format("%,d", lottoPrize.prize()) + "원) - " + lottoPrize.prizeCount() + "개");
                    });
        System.out.println("총 수익률은 " + String.format("%.1f", lottoResultResponse.returns()) + "%입니다.");
    }

    private void printNewLine() {
        System.out.println();
    }
}

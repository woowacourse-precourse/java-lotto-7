package lotto;

import java.util.List;
import java.util.Map;

public class OutputHandler {
    public void showCommentForPaymentInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showCommentForLottoNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showCommentForBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showLottoResultSummary(LottoTickets lottoTickets) {
        System.out.println("당첨 통계");
        System.out.println("---");
        showResultOfEachPlace(lottoTickets);

        double profitRate = lottoTickets.getProfitRate();
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }


    public void showTicketsOf(List<LottoTicket> ticketList) {
        System.out.println(ticketList.size() + "개를 구매했습니다.");

        for (LottoTicket lottoTicket : ticketList) {
            System.out.println(lottoTicket);
        }

        System.out.println();
    }

    public void showBlankLine() {
        System.out.println();
    }

    private static void showResultOfEachPlace(LottoTickets lottoTickets) {
        Map<LottoPlace, Integer> lottoResultSummary = lottoTickets.getLottoResultSummary();
        List<LottoPlace> winningPlaces = LottoPlace.getWinningPlaces();

        for (LottoPlace place : winningPlaces) {
            Integer numberOfCurrentPlaceTicket = lottoResultSummary.get(place);
            String summaryCommentOfCurrentPlace = place.provideSummaryComment(numberOfCurrentPlaceTicket);
            System.out.println(summaryCommentOfCurrentPlace);
        }
    }

}

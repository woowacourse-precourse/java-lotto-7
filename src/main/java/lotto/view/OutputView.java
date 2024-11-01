package lotto.view;

import lotto.view.response.LottoNumberResponse;
import lotto.view.response.LottoScoreResponse;
import lotto.view.response.LottoScoreResponses;
import lotto.view.response.PurchaseLottoResponse;

import java.util.stream.Collectors;

public class OutputView {

    public void printPurchasedLottos(PurchaseLottoResponse response) {
        System.out.printf("\n%d개를 구매했습니다.%n", response.getPurchasedAmount());

        response.getLottoNumberResponses().forEach(this::printLotto);
    }

    public void printScores(LottoScoreResponses response) {
        System.out.println("당첨 통계");
        System.out.println("---");
        response.getLottoScoreResponses().forEach(this::printScore);
    }

    private void printScore(LottoScoreResponse lottoScoreResponse, Integer count) {
        int matchCount = lottoScoreResponse.getMatchCount();
        if (matchCount == 0) {
            return;
        }
        boolean isBonusMatch = lottoScoreResponse.isBonusMatch();
        int prize = lottoScoreResponse.getPrize();

        String result = String.format("%d개 일치%s (%,d원) - %d개",
                matchCount,
                isBonusMatch ? ", 보너스 볼 일치" : "",
                prize,
                count);
        System.out.println(result);

    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private void printLotto(LottoNumberResponse response) {
        System.out.println(response.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));
    }
}

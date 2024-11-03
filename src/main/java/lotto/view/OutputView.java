package lotto.view;

import dto.LottosDTO;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.Rank;

public class OutputView {

    public void printLottos(LottosDTO lottosDTO) {
        System.out.println(lottosDTO.lottos().size() + "개를 구매했습니다.");
        lottosDTO.lottos().forEach(lottoDto ->
                System.out.println(lottoDto.numbers())
        );
    }

    public void printResults(Map<Rank, Long> results, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");

        printRankResults(results);
        printRateOfReturn(rateOfReturn);
    }

    private void printRankResults(Map<Rank, Long> results) {
        results.forEach((rank, count) -> {
            int prize = rank.getPrize();
            System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), prize, count);
        });
    }

    private void printRateOfReturn(double rateOfReturn) {
        String formattedRateOfReturn = String.format("%.1f", rateOfReturn);
        System.out.printf("총 수익률은 %s%%입니다.%n", formattedRateOfReturn);
    }
}

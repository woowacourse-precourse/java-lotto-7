package lotto.view;

import dto.LottoResultDTO;
import dto.LottosDTO;
import java.text.NumberFormat;
import java.util.List;

public class OutputView {

    public void printLottos(LottosDTO lottosDTO) {
        System.out.println(lottosDTO.lottos().size() + "개를 구매했습니다.");
        lottosDTO.lottos().forEach(lottoDto ->
                System.out.println(lottoDto.numbers())
        );
    }

    public void printResults(LottoResultDTO lottoResultDTO) {
        System.out.println("당첨 통계");
        System.out.println("---");

        printRankResults(lottoResultDTO);
        printRateOfReturn(lottoResultDTO.rateOfResult());
    }

    private void printRankResults(LottoResultDTO lottoResultDTO) {
        List<Integer> matchCounts = lottoResultDTO.matchCounts();
        List<Integer> prizes = lottoResultDTO.prizes();
        List<Long> counts = lottoResultDTO.counts();
        List<Boolean> requiresBonus = lottoResultDTO.requiresBonus();

        for (int i = 0; i < matchCounts.size(); i++) {
            String formattedPrize = formatPrize(prizes.get(i));
            printSingleRankResult(matchCounts.get(i), formattedPrize, counts.get(i), requiresBonus.get(i));
        }
    }

    private String formatPrize(int prize) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(prize);
    }

    private void printSingleRankResult(int matchCount, String formattedPrize, long count, boolean requiresBonus) {
        if (requiresBonus) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", matchCount, formattedPrize, count);
        }
        System.out.printf("%d개 일치 (%s원) - %d개%n", matchCount, formattedPrize, count);

    }

    private void printRateOfReturn(double rateOfReturn) {
        String formattedRateOfReturn = String.format("%.1f", rateOfReturn);
        System.out.println("총 수익률은 " + formattedRateOfReturn + "%입니다.");
    }
}

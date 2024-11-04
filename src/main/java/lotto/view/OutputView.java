package lotto.view;

import lotto.dto.LottoResultDTO;
import lotto.dto.LottosDTO;
import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private static final String LOTTO_PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String DASH_LINE = "---";
    private static final String RANK_RESULT_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String RANK_RESULT_FORMAT = "%d개 일치 (%s원) - %d개%n";
    private static final String TOTAL_RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLottos(LottosDTO lottosDTO) {
        printBlankLine();
        System.out.printf(LOTTO_PURCHASE_MESSAGE_FORMAT, lottosDTO.lottos().size());
        printBlankLine();
        lottosDTO.lottos().forEach(lottoDto ->
                System.out.println(lottoDto.numbers())
        );
        printBlankLine();
    }

    public void printResults(LottoResultDTO lottoResultDTO) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(DASH_LINE);

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
            System.out.printf(RANK_RESULT_WITH_BONUS_FORMAT, matchCount, formattedPrize, count);
            return;
        }
        System.out.printf(RANK_RESULT_FORMAT, matchCount, formattedPrize, count);
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.printf(TOTAL_RETURN_RATE_MESSAGE, rateOfReturn);
        System.out.println();
    }

    public void printBlankLine() {
        System.out.println();
    }
}

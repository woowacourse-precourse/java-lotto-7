package lotto.lottoapp.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningResult;
import lotto.lottoapp.model.value.WinningStatistics;

public class LottoOutput {

    public void showIssuedLottoNumbers(List<LottoNumbers> issuedLottoNumbers) {
        String issuedLottoMessageFormat = """
                %d개를 구매했습니다.
                %s
                """;
        System.out.printf(issuedLottoMessageFormat,
                issuedLottoNumbers.size(),
                getNumbersOf(issuedLottoNumbers));
    }

    public void announceWinningStatistics(WinningStatistics winningStatistics) {
        String statisticsMessageFormat = """
                당첨 통계
                ---
                %s
                총 수익률은 %s%%입니다.
                """;
        System.out.printf(statisticsMessageFormat,
                getTotalStatisticsOfWinningCount(winningStatistics),
                winningStatistics.getRateReturn());
    }

    private static String getNumbersOf(List<LottoNumbers> issuedLottoNumbers) {
        return issuedLottoNumbers.stream()
                .map(lineOfLotto -> lineOfLotto.stream()
                        .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String getFormattedMessageOfWinningCount(Map.Entry<WinningResult, Long> winCountEntry) {
        String lineOfSecondWinningMessageFormat = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
        String lineOfWinningMessageFormat = "%d개 일치 (%s원) - %d개";

        if (winCountEntry.getKey() == WinningResult.SECOND) {
            return String.format(lineOfSecondWinningMessageFormat,
                    winCountEntry.getKey().minCountOfWinningNumber,
                    winCountEntry.getKey().prize,
                    winCountEntry.getValue());
        }
        return String.format(lineOfWinningMessageFormat,
                winCountEntry.getKey().minCountOfWinningNumber,
                winCountEntry.getKey().prize,
                winCountEntry.getValue());
    }

    private static String getTotalStatisticsOfWinningCount(WinningStatistics winningStatistics) {
        int firstRank = 1;
        int fifthRank = 5;
        return IntStream.rangeClosed(firstRank, fifthRank).boxed()
                .sorted(Comparator.reverseOrder())
                .map(winningStatistics::findWinningBy)
                .map(LottoOutput::getFormattedMessageOfWinningCount)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}

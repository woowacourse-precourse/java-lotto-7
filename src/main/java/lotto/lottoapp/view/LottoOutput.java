package lotto.lottoapp.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningResult;
import lotto.lottoapp.model.value.WinningStatistics;

public class LottoOutput {

    public void showIssuedLottoNumbers(List<LottoNumbers> issuedLottoNumbers) {
        StringBuilder messageOfBuyLottos = new StringBuilder();
        messageOfBuyLottos.append(issuedLottoNumbers.size())
                .append("개를 구매했습니다.")
                .append(System.lineSeparator());

        issuedLottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.stream()
                        .map(number -> String.valueOf(number.getNumber()))
                        .collect(Collectors.joining(", ", "[", "]")))
                .forEach(lineOfLotto -> messageOfBuyLottos.append(lineOfLotto).append(System.lineSeparator()));

        System.out.println(messageOfBuyLottos);
    }

    public void announceWinningStatistics(WinningStatistics winningStatistics) {
        StringBuilder messageOfWinningStatistics = new StringBuilder();
        messageOfWinningStatistics.append("당첨 통계")
                .append(System.lineSeparator())
                .append("---")
                .append(System.lineSeparator());

        int firstRank = 1;
        int fifthRank = 5;
        IntStream.rangeClosed(firstRank, fifthRank).boxed()
                .sorted(Comparator.reverseOrder())
                .map(winningStatistics::findWinningBy)
                .forEach(winCountEntry -> {
                    if (winCountEntry.getKey() == WinningResult.SECOND) {
                        messageOfWinningStatistics.append(winCountEntry.getKey().minCountOfWinningNumber)
                                .append("개 일치, 보너스 볼 일치 (")
                                .append(winCountEntry.getKey().prize)
                                .append("원) - ")
                                .append(winCountEntry.getValue())
                                .append("개")
                                .append(System.lineSeparator());
                        return;
                    }
                    messageOfWinningStatistics.append(winCountEntry.getKey().minCountOfWinningNumber)
                            .append("개 일치 (")
                            .append(winCountEntry.getKey().prize)
                            .append("원) - ")
                            .append(winCountEntry.getValue())
                            .append("개")
                            .append(System.lineSeparator());
                });

        messageOfWinningStatistics.append("총 수익률은 ")
                .append(winningStatistics.getRateReturn())
                .append("%입니다.")
                .append(System.lineSeparator());

        System.out.println(messageOfWinningStatistics);
    }

}

package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Prize;
import lotto.domain.PublishLotto;

public class OutputView {

    private static final String WINNING_STAT_MESSAGE = "당첨 통계\n---\n";

    public void printPublishCountMessage(int publishCount) {
        System.out.printf("%d개를 구매했습니다.", publishCount);
    }

    public void printPublishLottos(List<PublishLotto> publishLottoList) {
        for (PublishLotto publishLotto : publishLottoList) {
            List<Integer> publishLottoNumbers = publishLotto.getPublishLottoNumbers();
            System.out.println("[" + numberFormatting(publishLottoNumbers) + "]");
        }
    }

    public void printWinningStatMessage(Map<Prize, Integer> winningCounts) {
        System.out.printf(WINNING_STAT_MESSAGE);
        for (Prize prize : Prize.values()) {
            System.out.printf("%s (%,d원) - %d개\n", prize.getMessage(), prize.getPrizeAmount(), winningCounts.getOrDefault(prize, 0));
        }
    }

    private String numberFormatting(List<Integer> publishLottoNumbers) {
        String numbersString = publishLottoNumbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
        return numbersString;
    }
}

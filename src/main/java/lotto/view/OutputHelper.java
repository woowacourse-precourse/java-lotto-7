package lotto.view;

import lotto.model.Rank;
import lotto.model.Result;

import java.util.List;
import java.util.StringJoiner;

public class OutputHelper {
    private final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private final String LINE_BREAK = "\n";
    private final String STATS_TITLE = "당첨 통계";
    private final String LINE = "---";
    private final String RESULT_FORMAT = "%s - %d개";
    private final String RATE_FORMAT = "총 수익률은 %s입니다.";
    private final List<Rank> rankList = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    public void printLotto(List<List<Integer>> numlists) {
        System.out.println(makeLottoList(numlists));
    }

    private String makeLottoList(List<List<Integer>> numlists) {
        StringJoiner message = new StringJoiner(LINE_BREAK);
        message.add(numlists.size()+PURCHASE_MESSAGE);

        for (List<Integer> numlist: numlists) {
            message.add(numlist.toString());
        }

        return message.toString();
    }

    public void printResult(Result result) {
        System.out.println(makeResult(result));
    }

    private String makeResult(Result result) {
        StringJoiner message = new StringJoiner(LINE_BREAK);

        message.add(STATS_TITLE);
        message.add(LINE);

        for (Rank rank : rankList) {
            message.add(makeRankResult(result, rank));
        }

        message.add(makeRateMessage(result));

        return message.toString();
    }

    private String makeRankResult(Result result, Rank rank) {
        return String.format(RESULT_FORMAT, rank.getDescription(), result.getCount(rank));
    }

    private String makeRateMessage(Result result) {
        return String.format(RATE_FORMAT, result.getRate());
    }
}

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

    /**
     * 구매한 로또 번호 출력
     *
     * @param numlists 구매한 로또 번호
     */
    public void printLotto(List<List<Integer>> numlists) {
        System.out.println(makeLottoList(numlists));
    }

    /**
     * 로또 번호 출력
     *
     * @param numlists 로또 번호 리스트
     * @return 로또 번호 현황
     */
    private String makeLottoList(List<List<Integer>> numlists) {
        StringJoiner message = new StringJoiner(LINE_BREAK);
        message.add(numlists.size() + PURCHASE_MESSAGE);

        for (List<Integer> numlist : numlists) {
            message.add(numlist.toString());
        }

        return message.toString();
    }

    /**
     * 로또 결과 출력
     *
     * @param result 로또 결과
     */
    public void printResult(Result result) {
        System.out.println(makeResult(result));
    }

    /**
     * 출력 형식에 맞는 로또 결과 생성
     *
     * @param result 로또 결과
     * @return 출력 형식에 맞는 로또 결과
     */
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

    /**
     * 등수 별 로또 결과 생성
     *
     * @param result 결과
     * @param rank   등수
     * @return 등수 결과
     */
    private String makeRankResult(Result result, Rank rank) {
        return String.format(RESULT_FORMAT, rank.getDescription(), result.getCount(rank));
    }

    /**
     * 출력의 형식에 맞는 로또 수익률 생성
     *
     * @param result 결과
     * @return 출력할 로또 수익률
     */
    private String makeRateMessage(Result result) {
        return String.format(RATE_FORMAT, result.getRate());
    }
}

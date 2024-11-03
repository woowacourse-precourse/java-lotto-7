package lotto.view;

import lotto.enums.Ranking;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String READ_MONEY_OUTPUT= "개를 구매했습니다.";
    private static final String RESULT_MESSAGE="당첨 통계";
    private static final String RESULT_DASH="---";
    private static final String RESULT_UNIT = "개";
    public void printMoney(int money) {
        System.out.println();
        System.out.println(money + READ_MONEY_OUTPUT);
    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers);
    }

    public void printResult(Map<Ranking, Integer> result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_DASH);
        for (Ranking ranking : result.keySet()) {
            System.out.println(ranking.getMessage()+result.get(ranking)+RESULT_UNIT);
        }
    }

    public void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", returnRate) + "%입니다.");
    }

}

package lotto.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printWinningDetail(Map<String, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String key : result.keySet()) {
            System.out.println(key + " - " + result.get(key) + "개");
        }
    }

    public void printResult(String result) {
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

    public static void printException(String message) {
        System.out.println(message);
    }
}

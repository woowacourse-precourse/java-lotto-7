package lotto.view;

import lotto.model.UserNumber;
import lotto.model.UserNumbers;

import java.util.List;

public class OutputView {
    public void printUserLotto(UserNumbers userNumbers) {
        System.out.println("\n" + userNumbers.getPurchaseCount() + "개를 구매했습니다.");
        for (UserNumber userNumber : userNumbers.getUserNumbers()) {
            System.out.println(userNumber.getUserNumber());
        }
    }

    public void printResult(List<Integer> results, double rate) {
        System.out.println("\n당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + results.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(4) + "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}

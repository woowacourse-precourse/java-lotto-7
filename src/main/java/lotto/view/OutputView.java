package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.service.SortLottoNumberService;

public class OutputView {
    public static void printIssuedLotto(Lotto issuedLotto) {
        System.out.println(SortLottoNumberService.sortLottoNumber(issuedLotto.getNumbers()));
    }

    public static void printIssuedLottoNumber(List<Lotto> issuedLotto, int quantity) {
        System.out.println("\n" + quantity + "개를 구매했습니다.");
        for (Lotto lotto : issuedLotto) {
            printIssuedLotto(lotto);
        }
    }

    public static void printWinningDetails(Map<String, Integer> statistics, double profit) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get("3개") + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get("4개") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get("5개") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get("5개+보너스") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get("6개") + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}

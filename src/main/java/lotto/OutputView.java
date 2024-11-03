package lotto;

import java.util.List;

public class OutputView {
    public static void promptForAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void promptForLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void promptForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult(LottoResultCounter resultCounter, int cost) {
        System.out.println("당첨 통계\n---");
        System.out.println(resultCounter);
        float returnRate = (float)Math.round((float)resultCounter.getProfit() / cost * 1000) / 10;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}

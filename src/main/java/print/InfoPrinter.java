package print;

import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class InfoPrinter {
    public void purchasedLottoInfoPrint(int sum, List<Lotto> lottos) {
        System.out.println(sum + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void winningResultPrint(Map<Integer, Integer> results) {
        for (int i = 5; i > 0; i--) {
            revenue(i, results.get(i));
        }
    }

    private void revenue(int rank, int count) {
        if (rank == 1) {
            System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
        }
        if (rank == 2) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        }
        if (rank == 3) {
            System.out.println("5개 일치 (1,500,000원) - " + count + "개");
        }
        if (rank == 4) {
            System.out.println("4개 일치 (50,000원) - " + count + "개");
        }
        if (rank == 5) {
            System.out.println("3개 일치 (5,000원) - " + count + "개");
        }
    }
}

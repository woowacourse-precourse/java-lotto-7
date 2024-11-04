package print;

import java.util.List;
import lotto.Lotto;

public class InfoPrinter {
    public void purchasedLottoInfoPrint(int sum, List<Lotto> lottos) {
        System.out.println(sum + "개를 구매했습니다");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    /**
     * 차후에 변경할 메서드입니다. 존재의 의미를 잊지 않기 위해 임시로 구현해두었습니다.
     */
    public void winningResultPrint(List<Integer> results) {
        for (int i = 6; i > 0; i--) {
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

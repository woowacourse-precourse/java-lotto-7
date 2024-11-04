package lotto.view;

import java.util.List;
import lotto.model.dto.LottoGameResult;

public class OutputView {

    public void showCreatedLottos(List<List<Integer>> allNumbers) {
        showDivider();
        System.out.println(allNumbers.size() + "개를 구매했습니다.");
        for (List<Integer> numbers : allNumbers) {
            System.out.println(numbers);
        }
    }

    public void showDrawResults(List<LottoGameResult> result, double earns) {
        showDivider();
        System.out.println("당첨 통계\n---");
        for (LottoGameResult singleResult : result) {
            if (singleResult.getPrize() == 30000000) {
                System.out.println(
                        singleResult.getNum() + "개 일치, 보너스 볼 일치 (" + String.format("%,d", singleResult.getPrize()) + "원) - "
                                + singleResult.getCount()
                                + "개");
                continue;
            }
            System.out.println(
                    singleResult.getNum() + "개 일치 (" + String.format("%,d", singleResult.getPrize()) + "원) - " + singleResult.getCount()
                            + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", earns) + "%입니다.");
    }

    private void showDivider() {
        System.out.println();
    }
}

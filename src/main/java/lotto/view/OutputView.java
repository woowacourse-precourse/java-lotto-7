package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        lottos.forEach(lotto ->
                System.out.println(lotto.getNumbers()));
    }

    public void printStatistics(double statistics) {
        String rounded = String.format("%.1f", statistics);
        System.out.println("총 수익률은 "+rounded+"%입니다.");
    }
}

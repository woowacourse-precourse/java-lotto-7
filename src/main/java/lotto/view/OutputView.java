package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void printLottoCountAndNumbers(int count, List<Lotto> lottos){
        System.out.println(count + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}

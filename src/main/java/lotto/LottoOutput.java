package lotto;

import java.util.List;

public class LottoOutput {
    public void printLottos(List<Lotto> lottos, int count) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}

package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printBoughtLottoList(List<Lotto> lottoList) {
        int count = lottoList.size();
        System.out.println(count + "개를 구매했습니다.");

        lottoList.forEach((lotto -> {
            System.out.println(lotto.getNumbers());
        }));
    }
}

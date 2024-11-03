package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public void printLotties(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.size());
        for (Lotto lotto : lottoList) {
            String numbers = String.join(",", lotto.get().stream().map(String::valueOf).toList());
            System.out.println("[" + numbers + "]");
        }
    }
}

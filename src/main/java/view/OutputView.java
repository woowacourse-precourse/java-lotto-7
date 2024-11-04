package view;

import java.util.List;

import lotto.Lotto;

public class OutputView {
    public static void printLotto(int lottoCount, List<Lotto> lottoList) {
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
}

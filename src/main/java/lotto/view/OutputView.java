package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public static void printLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public static void printMyLottoNumber(List<Lotto> myLottos) {
        for (Lotto lotto : myLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}

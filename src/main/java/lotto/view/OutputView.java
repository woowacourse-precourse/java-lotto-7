package lotto.view;

import lotto.model.Lotto;

public class OutputView {
    public void printUnitCount(int thousandUnitCount) {
        System.out.println(thousandUnitCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottos(Lotto lotto) {
        System.out.println(lotto);
    }
}

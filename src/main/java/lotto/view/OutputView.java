package lotto.view;

import lotto.util.RandomNumberUtils;

public class OutputView {
    public void printUnitCount(int thousandUnitCount) {
        System.out.println(thousandUnitCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottos(int thousandUnitCount) {
        for (int count = 0; count < thousandUnitCount; count++) {
            System.out.println(RandomNumberUtils.getRandomNumbers().toString());
        }
    }
}

package lotto.purchase;

import java.util.List;

public record LottoReceipt(int payment, List<MyLotto> myLotteries) {

    public static final int LOTTO_PRICE = 1000;

    public void printTotalLottoNumber() {
        System.out.println((payment / LOTTO_PRICE) + "개를 구매했습니다.");
    }

    public void printAllLotteries() {
        for (MyLotto lotto : myLotteries) {
            System.out.println(lotto.numbers());
        }
    }
}

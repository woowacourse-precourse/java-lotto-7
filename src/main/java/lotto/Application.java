package lotto;

import lotto.domain.consumer.Consumer;

public class Application {
    public static void main(String[] args) {
        WoowahanLottoCompany company = new WoowahanLottoCompany();
        Consumer consumer = new Consumer();
        company.enterForLottoPurchase(consumer);
        company.printLottoWinningResult(consumer);
    }
}

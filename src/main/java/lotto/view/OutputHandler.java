package lotto.view;

import lotto.domain.lottoNumber.RandomNumberGenerator;

public class OutputHandler {

    RandomNumberGenerator generator = new RandomNumberGenerator();

    public void printPurchasedLotto(int lottoCount) {
        String purchasedLotto = generator.getPurchasedLotto(lottoCount);

        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        System.out.println(purchasedLotto);
    }
}

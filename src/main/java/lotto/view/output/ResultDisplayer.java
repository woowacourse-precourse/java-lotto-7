package lotto.view.output;

import lotto.model.Lottos;

public class ResultDisplayer {

    private final String LOTTO_COUNT_MESSAGE_SUFFIX = "개를 구매했습니다.";

    public void showPurchasedLottos(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE_SUFFIX);
        lottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }
}

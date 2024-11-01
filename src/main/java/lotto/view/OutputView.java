package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    private Lottos lottos;

    public OutputView(Lottos lottos) {
        this.lottos = lottos;
    }

    public void outputLottoCount() {
        System.out.println(lottos.getLottoCount() + LOTTO_COUNT_MESSAGE);
    }
}

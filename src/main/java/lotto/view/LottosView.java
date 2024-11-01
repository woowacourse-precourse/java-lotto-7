package lotto.view;

import lotto.model.lotto.Lottos;

public class LottosView {

    private final String lottos;
    private final int lottoCount;

    private LottosView(final String lottos, final int lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public static LottosView from(Lottos lottos, int lottoCount) {
        return new LottosView(lottos.toString(), lottoCount);
    }

    public String getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}

package lotto.util;

import lotto.view.LottoView;

public abstract class LottoStarter {

    private static final LottoView lottoView =
            SingletonObjectProvider.getSingletonObject(LottoView.class);

    public static void start() {
        lottoView.startLottoProgram();
    }
}
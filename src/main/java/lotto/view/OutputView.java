package lotto.view;

import lotto.domain.Lottos;

import static lotto.message.InfoMessage.LOTTO_COUNT_INFO;

public class OutputView {
    public static void showLottosInfo(Lottos lottos){
        long lottoCount = lottos.getLottoCount();
        System.out.println(LOTTO_COUNT_INFO.formatNumber(lottoCount));
        lottos.showInfo();
    }
}

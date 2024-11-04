package lotto;

import lotto.woowaLotto.lottoPlayer.LottoList;
import lotto.woowaLotto.lottoPlayer.LottoPlayer;
import lotto.woowaLotto.lottoPlayer.LottoType;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoPlayer().start(LottoList.getLottoWay(LottoType.AUTO));
    }
}

package lotto.woowaLotto.lottoPlayer;

import java.util.HashMap;
import java.util.Map;
import lotto.woowaLotto.lottoPlayer.woowaLotto.WooWaLotto;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.WooWaAutoLotto;

public class LottoList {

    private final static Map<LottoType, WooWaLotto> lottos = new HashMap<>() {{
        put(LottoType.AUTO,new WooWaAutoLotto());
    }};

    public static WooWaLotto getLottoWay(LottoType lottoType){
        return lottos.get(lottoType);
    }
}

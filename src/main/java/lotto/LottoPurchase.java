package lotto;

import java.util.ArrayList;
import java.util.List;

// 사용자가 입력한 금액에 따라 로또 티켓 구매
public class LottoPurchase {
    public static List<Lotto> purchaseLottos(int money) {
        int count = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return lottos;
    }
}
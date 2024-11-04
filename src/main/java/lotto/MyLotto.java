package lotto;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {
    private final List<Lotto> lottos;
    private final Lotto winPrice;
    private final int bonus;

    public MyLotto(Lotto winPrice, int bonus) {
        this.lottos = new ArrayList<>();
        this.winPrice = winPrice;
        this.bonus = bonus;
    }

    // 이를 통해서만 데이터 추가 가능
    public void add(Lotto lotto) {
        lottos.add(lotto);
    }


}

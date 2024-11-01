package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    public static List<Lotto> issueLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }
}

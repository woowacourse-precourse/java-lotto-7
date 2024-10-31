package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    List<Lotto> lottos;

    public LottoTicket(int lottoCount) {
        ArrayList<Lotto> temp = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            temp.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        lottos = temp;
    }

    public int getLottoCount() {
        return lottos.size();
    }
}

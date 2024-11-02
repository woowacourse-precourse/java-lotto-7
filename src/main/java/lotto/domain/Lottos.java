package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int ticketCount) {
        this.lottos = makeLottos(ticketCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> makeLottos(int ticketCount) {
        List<Lotto> temp = new ArrayList<>();
        IntStream.range(0, ticketCount)
                .forEach(lotto -> temp.add(new Lotto(chooseRandomLottoNumbers())));
        return temp;
    }

    private List<Integer> chooseRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}

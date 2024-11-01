package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> lottos;
    private static LottoMachine instance;

    public LottoMachine() {
        this.lottos = new ArrayList<>();
    }

    public static LottoMachine getInstance() {
        if (instance == null) {
            instance = new LottoMachine();
        }
        return instance;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void createLottos(int lottoCount) {
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

    public void printAllLottoNumbers() {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}

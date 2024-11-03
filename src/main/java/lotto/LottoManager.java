package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    private final List<Lotto> lottoRepository;

    public LottoManager(int purchasePrice) {
        this.lottoRepository = generateLottos(purchasePrice / 1000);
    }

    private List<Lotto> generateLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public List<Lotto> getLottoRepository() {
        return lottoRepository;
    }
}

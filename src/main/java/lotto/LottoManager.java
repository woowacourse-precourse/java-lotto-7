package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    public static final int PURCHASING_UNIT = 1000;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    private final List<Lotto> lottoRepository;

    public LottoManager(int purchasePrice) {
        this.lottoRepository = generateLottos(purchasePrice / PURCHASING_UNIT);
    }

    private List<Lotto> generateLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT));
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottoRepository;
    }
}

package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {

    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    private List<Lotto> lottos;

    public PurchasedLotto(int lottoQuantity) {
        this.lottos = new ArrayList<>(lottoQuantity);

        createLottos(lottoQuantity);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void createLottos(int quantity) {
        for (int i = 0 ; i < quantity ; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .toList();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

}

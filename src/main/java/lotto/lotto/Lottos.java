package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = new ArrayList<>();
        generateLottos(count);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseLottoCount() {
        return lottos.size();
    }

    private void generateLottos(int count) {
        for (int currentCount = 0; currentCount < count; currentCount++) {
            List<Integer> numbers =
                    new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                            LottoConstant.MIN_LOTTO_NUMBER.getValue(),
                            LottoConstant.MAX_LOTTO_NUMBER.getValue(),
                            LottoConstant.LOTTO_SIZE.getValue()));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
    }
}

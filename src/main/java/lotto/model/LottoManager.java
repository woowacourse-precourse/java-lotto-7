package lotto.model;

import static lotto.utils.Constants.*;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoManager {
    private final List<Lotto> lottos;

    public LottoManager() {
        lottos = new ArrayList<>();
    }

    public List<Integer> addLotto() {
        List<Integer> drawNumbers = drawLottoNumbers();
        lottos.add(new Lotto(drawNumbers));
        return new ArrayList<>(drawNumbers);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    private List<Integer> drawLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}

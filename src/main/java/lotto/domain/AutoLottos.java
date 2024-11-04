package lotto.domain;

import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER_COUNT;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottos {

    private final List<Lotto> autoLottos;

    public AutoLottos(int purchaseAmount) {
        this.autoLottos = makeAutoLottos(purchaseAmount);
    }

    public List<Lotto> getAutoLottos() {
        return Collections.unmodifiableList(autoLottos);
    }

    private List<Lotto> makeAutoLottos(int purchaseAmount) {
        int lottoCnt = purchaseAmount / 1000;
        List<Lotto> autoLottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            autoLottos.add(makeAutoLotto());
        }

        return autoLottos;
    }

    private Lotto makeAutoLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER_COUNT)
            .stream()
            .sorted()
            .collect(Collectors.toList());

        return new Lotto(numbers);
    }
}

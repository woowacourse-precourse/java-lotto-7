package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRandom {

    private List<Lotto> randomLotto;

    public List<Lotto> generateLottoRandom(int lottoCounts) {
        randomLotto = new ArrayList<>();

        for (int i = 0; i < lottoCounts; i++) {
            randomLotto.add(new Lotto(sortNumbers()));
        }

        return randomLotto;
    }

    private List<Integer> sortNumbers() {
        return generateRandomNumber().stream().sorted().collect(Collectors.toList());
    }

    private List<Integer> generateRandomNumber() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.*;

public class Generate {
    double cost;

    public Generate(double cost) {
        this.cost = cost;
    }

    public List<Lotto> getLottoPaper() {
        List<Lotto> lotto = new ArrayList<>();

        for (int round = 0; round < cost / LOTTO_CHARGE; round++) {
            List<Integer> subGame = getSubGame();
            lotto.add(new Lotto(subGame));
        }

        return lotto;
    }

    public List<Integer> getSubGame() {
        List<Integer> subGame = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_NUMBERS_LIMIT));
        Collections.sort(subGame);

        return subGame;
    }
}

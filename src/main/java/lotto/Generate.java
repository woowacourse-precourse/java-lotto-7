package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generate {
    private static final int LOTTO_CHARGE = 1000;
    int cost;

    public Generate(int cost) {
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
        List<Integer> list = new ArrayList<>();

        while (list.size() < 6) {
            int randomNum = Randoms.pickNumberInRange(1, 45);
            if (!list.contains(randomNum)) {
                list.add(randomNum);
            }
        }

        Collections.sort(list);

        return list;
    }
}

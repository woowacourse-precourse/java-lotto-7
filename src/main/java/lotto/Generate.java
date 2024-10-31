package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generate {
    int cost;

    public Generate(int cost) {
        this.cost = cost;
    }

    public List<Lotto> getLottoPaper() {
        List<Lotto> lotto = new ArrayList<>();

        for (int round = 0; round < cost / Constant.LOTTO_CHARGE; round++) {
            List<Integer> subGame = getSubGame();
            lotto.add(new Lotto(subGame));
        }

        return lotto;
    }

    public List<Integer> getSubGame() {
        List<Integer> list = new ArrayList<>();

        while (list.size() < Constant.LOTTO_ONE_LINE) {
            int randomNum = Randoms.pickNumberInRange(Constant.LOTTO_START, Constant.LOTTO_END);
            if (!list.contains(randomNum)) {
                list.add(randomNum);
            }
        }

        Collections.sort(list);

        return list;
    }
}

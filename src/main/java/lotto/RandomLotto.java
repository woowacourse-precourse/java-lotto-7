package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLotto {
    private static RandomLotto instance;
    private final List<List<Integer>> randomLottos;
    IOManager ioManager;

    private RandomLotto() {
        randomLottos = new ArrayList<>();
    }

    public static RandomLotto getInstance() {
        if (instance == null) {
            instance = new RandomLotto();
        }
        return instance;
    }

    public void countCalculator(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.");
        }

        newLottos(money / 1000);
    }

    public List<Integer> pickNewLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void newLottos(int cnt) {
        for (int i = 0; i < cnt; i++) {
            List<Integer> lotto = pickNewLotto();
            randomLottos.add(lotto);
        }

        ioManager.printNewLotto(cnt, randomLottos);
    }
}

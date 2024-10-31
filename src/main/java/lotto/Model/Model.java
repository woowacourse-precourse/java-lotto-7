package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Lotto> numbers = new ArrayList<Lotto>();

    public Model(int count) {
        for (int i = 0; i < count; i++) {
            numbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }
}

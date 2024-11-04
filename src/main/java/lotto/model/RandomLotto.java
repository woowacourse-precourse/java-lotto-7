package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLotto {
    private List<List<Integer>> lotto;

    public RandomLotto(int cnt){
        lotto = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            lotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }
    public List<List<Integer>> getLotto(){
        return this.lotto;
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Consumer {
    private List<Lotto> lotto;

    private void setLotto(List<Integer> numbers){
        Lotto lotto = new Lotto(numbers);
        this.lotto.add(lotto);
    }

    public List<Lotto> getLotto() {
        return this.lotto;
    }
}

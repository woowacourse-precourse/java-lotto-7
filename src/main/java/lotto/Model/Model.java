package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Lotto> numbers = new ArrayList<Lotto>();
    private List<Integer> winNumbers;
    private int bonusNumber;


    public Model(int count) {
        for (int i = 0; i < count; i++) {
            numbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void getWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void getBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getNumbers() {
        return numbers;
    }
}

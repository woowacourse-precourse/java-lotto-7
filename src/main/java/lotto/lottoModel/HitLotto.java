package lotto.lottoModel;

import java.util.ArrayList;
import java.util.List;

public class HitLotto {
    private final List<Integer> hitNumbers;
    private final int bonusNumber;

    public HitLotto(List<Integer> hitLotto, int bonusNumber) {
        this.hitNumbers = hitLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getALlHitNumbers() {
        List<Integer> allNumbers = new ArrayList<>(hitNumbers);
        allNumbers.add(bonusNumber);
        return allNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}

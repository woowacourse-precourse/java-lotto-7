package lotto;

import java.util.List;

public class HitLotto {
    private final List<Integer> hitNumbers;
    private final int bonusNumber;
    public HitLotto(List<Integer> hitNumbers, int bonusNumber){
        this.hitNumbers=hitNumbers;
        this.bonusNumber=bonusNumber;
    }
    public List<Integer> getHitNumbers() {
        return hitNumbers;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }


}

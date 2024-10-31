package lotto.lottoModel;

import java.util.List;

public class HitLottoDTO {
    private List<Integer> hitNumbers;
    private int bonusNumber;

    public HitLottoDTO(List<Integer> hitNumbers, int bonusNumber) {
        this.hitNumbers = hitNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getHitNumbers() {
        return hitNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

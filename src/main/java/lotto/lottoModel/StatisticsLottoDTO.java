package lotto.lottoModel;

import java.util.Map;
import java.util.Set;

public class StatisticsLottoDTO {

    private Map<Integer, Integer> hitNumberFrequency;
    private int bonusNumberFrequency;

    public StatisticsLottoDTO(Map<Integer, Integer> hitNumberFrequency, int bonusNumberFrequency) {
        this.hitNumberFrequency = hitNumberFrequency;
        this.bonusNumberFrequency = bonusNumberFrequency;
    }

    public Map<Integer, Integer> getHitNumberFrequency() {
        return hitNumberFrequency;
    }

    public int getBonusNumberFrequency() {
        return bonusNumberFrequency;
    }
}

package lotto.lottoModel;

import java.util.HashMap;
import java.util.Map;

public class StatisticsLotto {
    private static final int THREE_HIT = 3;
    private static final int FOUR_HIT = 4;
    private static final int FIVE_HIT = 5;
    private static final int SIX_HIT = 6;
    private static final int INITIALIZE = 0;
    private static final int UPDATE = 1;
    
    private Map<Integer, Integer> hitNumberFrequency;  // 맞춘 개수 빈도 저장
    private int bonusNumberFrequency;          // 보너스가 포함된 경우 저장

    public StatisticsLotto() {
        this.hitNumberFrequency = new HashMap<>();
        this.bonusNumberFrequency = INITIALIZE;

        hitNumberFrequency.put(THREE_HIT, INITIALIZE);
        hitNumberFrequency.put(FOUR_HIT, INITIALIZE);
        hitNumberFrequency.put(FIVE_HIT, INITIALIZE);
        hitNumberFrequency.put(SIX_HIT, INITIALIZE);
    }

    // 맞춘 개수의 빈도를 업데이트하는 메서드
    public void updateFrequency(int size) {
        if (size >= THREE_HIT && size <= SIX_HIT) {  // 크기가 3 이상 6 이하일 때만 기록
            hitNumberFrequency.put(size, hitNumberFrequency.getOrDefault(size, INITIALIZE) + UPDATE);
        }
    }

    // 보너스가 포함된 경우 +1
    public void addSpecificValue() {
        bonusNumberFrequency++;
    }

    // 빈도수 정보를 반환하는 메서드
    public Map<Integer, Integer> getHitNumberFrequency() {
        return hitNumberFrequency;
    }

    // 보너스 정보를 반환하는 메서드
    public int getBonusNumberFrequency() {
        return bonusNumberFrequency;
    }
}
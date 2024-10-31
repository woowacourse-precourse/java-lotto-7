package lotto.lottoModel;

import java.util.HashMap;
import java.util.Map;

public class StatisticsLotto {

    private Map<Integer, Integer> hitNumberFrequency;  // 맞춘 개수 빈도 저장
    private int bonusNumberFrequency;          // 보너스가 포함된 경우 저장

    public StatisticsLotto() {
        this.hitNumberFrequency = new HashMap<>();
        this.bonusNumberFrequency = 0 ;

        hitNumberFrequency.put(3, 0);
        hitNumberFrequency.put(4, 0);
        hitNumberFrequency.put(5, 0);
        hitNumberFrequency.put(6, 0);
    }

    // 맞춘 개수의 빈도를 업데이트하는 메서드
    public void updateFrequency(int size) {
        if (size >= 3 && size <= 6) {  // 크기가 3 이상 6 이하일 때만 기록
            hitNumberFrequency.put(size, hitNumberFrequency.getOrDefault(size, 0) + 1);
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
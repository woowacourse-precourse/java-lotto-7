package lotto.lottoModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HitLotto {
    private final List<Integer> hitNumbers;
    private final int bonusNumber;

    // 싱글톤 인스턴스
    private static HitLotto instance;

    private HitLotto(List<Integer> hitNumbers, int bonusNumber) {
        this.hitNumbers = Collections.unmodifiableList(new ArrayList<>(hitNumbers)); // 불변 리스트
        this.bonusNumber = bonusNumber;
    }

    // 싱글톤 인스턴스를 반환하는 메서드
    public static HitLotto getInstance(List<Integer> hitNumbers, int bonusNumber) {
        if (instance == null) {
            instance = new HitLotto(hitNumbers, bonusNumber);
        }
        return instance;
    }

    public List<Integer> getAllHitNumbers() {
        List<Integer> allNumbers = new ArrayList<>(hitNumbers);
        allNumbers.add(bonusNumber);
        return allNumbers;
    }

    public List<Integer> getHitNumbers() {
        return hitNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}

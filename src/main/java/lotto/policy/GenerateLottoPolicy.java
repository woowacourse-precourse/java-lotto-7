package lotto.policy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public enum GenerateLottoPolicy {
    RANDOM(1, 45, 6);

    private final int min;
    private final int max;
    private final int count;

    GenerateLottoPolicy(int min, int max, int count) {
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public static GenerateLottoPolicy getGeneratePolicy() {
        return RANDOM;
    }

    public List<Integer> getLottoList() {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}

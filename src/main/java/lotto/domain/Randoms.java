package lotto.domain;

import java.util.List;

public class Randoms {
    private static final int START = 1;
    private static final int END = 45;

    private final List<Integer> randoms;

    public Randoms(int count) {
        this.randoms = createRandoms(count);
    }

    private List<Integer> createRandoms(int count) {
        return camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(START, END, count);
    }

    public List<Integer> getRandoms() {
        return List.copyOf(randoms);
    }
}

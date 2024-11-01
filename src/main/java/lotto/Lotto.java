package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean isBonusBallMatch(Integer bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int getCorrectCount(Lotto winner) {
        int count = 0;
        for (Integer number : numbers) {
            if (winner.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static Lotto getRandom() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Lotto> getRandoms(int n) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lottos.add(getRandom());
        }
        return lottos;
    }
    // TODO: 추가 기능 구현
}

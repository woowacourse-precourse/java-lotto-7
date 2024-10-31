package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RandomNumber {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> randomNumber;

    private RandomNumber(List<Integer> randomNumber) { // TODO 과도한 캡슐화인지 고민하기 -> 테스트 실패 원인 찾기
        randomNumber.sort(Comparator.naturalOrder());
        this.randomNumber = randomNumber;
    }

    public static RandomNumber generate() {
        return new RandomNumber(
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE)
        );
    }

    public List<Integer> randomNumber() {
        return Collections.unmodifiableList(randomNumber);
    }
}

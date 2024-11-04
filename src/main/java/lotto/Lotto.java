package lotto;

import static lotto.InputUtil.checkOverThanMinAndLessThanMax;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_BASIC_PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSixCount(numbers);
        validateNoDuplicates(numbers);
        validateCoverage(numbers);
        this.numbers = numbers;
    }

    // 랜덤 로또 생성
    public static Lotto makeRandomLotto(){
        return new Lotto(generateUniqueRandomNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 6자리 숫자인지 확인
    private void validateSixCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 중복된 값이 있는지 확인
    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    // 리스트 내의 모든 숫자가 범위 내인지 확인
    private void validateCoverage(List<Integer> numbers) {
        for (int i : numbers) {
            checkOverThanMinAndLessThanMax(i, LOTTO_MIN_NUM, LOTTO_MAX_NUM);
        }
    }

    // 랜덤 번호 생성
    private static List<Integer> generateUniqueRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < LOTTO_SIZE) {
            int randomNumber = random.nextInt(LOTTO_MAX_NUM - LOTTO_MIN_NUM + 1) + LOTTO_MIN_NUM;
            uniqueNumbers.add(randomNumber);
        }

        return new ArrayList<>(uniqueNumbers);
    }

}

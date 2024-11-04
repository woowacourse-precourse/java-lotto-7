package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = generateRandomNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    // TODO: 추가 기능 구현
    private List<Integer> generateRandomNumbers() {
         List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
         List<Integer> mutableNumbers = new ArrayList<>(randomNumbers);
         mutableNumbers.sort(Integer::compareTo);
         return mutableNumbers;

    }

    // 로또 번호 중복 테스트
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> testSet = new HashSet<>();

        for (int number : numbers) {
            if (!testSet.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 1부터 45 사이의 숫자가 아닙니다.");
            }
        }
    }


    public void printLottery() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        int matchCount = 0;
        for (int number: numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean containBonusNumber(int bonus) {
        return numbers.contains(bonus);
    }
}

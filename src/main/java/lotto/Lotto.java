package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = numbers;
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto[] generateLottos(int lottoCount) {
        Lotto[] lottos = new Lotto[lottoCount];
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(numbers);
        }
        return lottos;
    }

    public void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void sortNumbers() {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 1; j < numbers.size() - i; j++) {
                swap(j);
            }
        }
    }

    private void swap(int j) {
        if (numbers.get(j) < numbers.get(j - 1)) {
            int temp = numbers.get(j);
            numbers.set(j, numbers.get(j - 1));
            numbers.set(j - 1, temp);
        }
    }

    public static void printLottos(Lotto[] lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

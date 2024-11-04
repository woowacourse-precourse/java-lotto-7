package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new ValidatorLottoNumber(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    protected static class ValidatorLottoNumber {
        public ValidatorLottoNumber(List<Integer> numbers) {
            validate(numbers);
            for(int num : numbers){
                checkBoundaryLottoNumber(num);
            }
            checkDuplicatesNumber(numbers);
        }

        public ValidatorLottoNumber(List<Integer> numbers, int bonusNumber) {
            checkBoundaryLottoNumber(bonusNumber);
            List<Integer> winningBonusNumbers = new ArrayList<>(numbers);
            winningBonusNumbers.add(bonusNumber);
            checkDuplicatesNumber(winningBonusNumbers);
        }

        private void validate(List<Integer> numbers) {
            if (numbers.size() != LOTTO_NUMBER_COUNT) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }

        private static void checkBoundaryLottoNumber(int number) {
            if (number > MAX_LOTTO_NUMBER)
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나는 번호가 있습니다.");
            if (number < MIN_LOTTO_NUMBER)
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나는 번호가 있습니다.");
        }

        private static void checkDuplicatesNumber(List<Integer> numbers) {
            boolean hasDuplicates = numbers.stream().distinct().count() != numbers.size();
            if (hasDuplicates) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 번호가 있습니다.");
            }
        }
    }
}

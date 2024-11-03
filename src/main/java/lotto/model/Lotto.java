package lotto.model;

import lotto.dto.MatchInfo;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public MatchInfo makeMatchInfo(Lotto userLotto, int bonusNumber) {
        int matchCount = 0;
        boolean isMatchBonusNumber = false;

        for (Integer userLottoNumber : userLotto.numbers) {
            if (this.numbers.contains(userLottoNumber)) {
                matchCount++;
            }
        }

        if (this.numbers.contains(bonusNumber)) {
            isMatchBonusNumber = true;
        }

        return new MatchInfo(matchCount, isMatchBonusNumber);
    }

    public String getLottoNumbers() {
        return formatLottoNumber() + "\n";
    }

    public void checkBonusNumberDuple(int bonusNumber) {
        if (numbers.contains(Integer.valueOf(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호가 중복되면 안됩니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        checkNumberDuple(numbers);
        checkValidArrange(numbers);
    }

    private void checkValidArrange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 수만 가능합니다.");
            }
        }
    }

    private void checkNumberDuple(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 중복되면 안됩니다.");
            }
            uniqueNumbers.add(number);
        }
    }

    private String formatLottoNumber() {
        List<Integer> sortLottoNumbers = sortLottoNumbers();
        return String.join(", ", Arrays.toString(sortLottoNumbers.toArray()));
    }

    private List<Integer> sortLottoNumbers() {
        return numbers.stream().sorted().toList();
    }
}

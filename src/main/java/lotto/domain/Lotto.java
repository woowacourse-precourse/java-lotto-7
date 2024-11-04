package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.Constants;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
//        validate(numbers);
        extractRandomNumbers();
    }

//    private void validate(List<Integer> numbers) {
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
//        }
//    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void extractRandomNumbers() {
        int startRange = Constants.LOTTO_START_RANGE.getValue();
        int finishRange = Constants.LOTTO_FINISH_RANGE.getValue();
        int lottoCount = Constants.LOTTO_COUNT.getValue();
        this.numbers = Randoms.pickUniqueNumbersInRange(startRange, finishRange, lottoCount).stream().sorted().toList();
    }

    public LottoCount matchLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean hasBonusNumber = false;
        for (int i = 0; i < 6; i++) {
            if (winningNumbers.contains(numbers.get(i))) {
                matchCount++;
            }
        }
        if (winningNumbers.contains(bonusNumber)) {
            hasBonusNumber = true;
        }
        return new LottoCount(matchCount, hasBonusNumber);
    }
}

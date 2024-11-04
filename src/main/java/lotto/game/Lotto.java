package lotto.game;

import lotto.Utils.Convertor;
import lotto.dto.LottoPrize;
import lotto.dto.Buyer;
import lotto.dto.WinningNumbers;
import lotto.io.OutputHandler;
import lotto.validation.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicatedNumbers(numbers);
        this.numbers = Convertor.sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void printLotto() {
        OutputHandler.printLottos(Convertor.convert(numbers));
    }

    public LottoPrize getLottoPrize(Buyer buyer) {
        WinningNumbers winningNumbers = buyer.getwinningNumbers();
        int matchCount = winningNumbers.checkMatchingCount(numbers);
        boolean hasBonusNumber = hasBonusNumber(buyer.getBonusNumber());

        if (matchCount == 5 && hasBonusNumber) {
            return LottoPrize.BONUS;
        }
        return decidePrize(matchCount);
    }

    private LottoPrize decidePrize(int matchCount) {
        if (matchCount > 2) {
            return LottoPrize.values()[matchCount - 3];
        }
        return null;
    }

    private boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}

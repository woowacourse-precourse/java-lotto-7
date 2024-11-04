package lotto.factory;

import lotto.domain.model.Lotto;
import lotto.domain.result.WinningLotto;

import java.util.Arrays;
import java.util.List;

public class WinningLottoFactory {
    public WinningLotto create(String winningNumbers, String bonusNumber) {
        List<Integer> numbers = parseNumbers(winningNumbers);
        validate(numbers);
        return new WinningLotto(new Lotto(numbers), Integer.parseInt(bonusNumber));
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다");
        }
    }
}

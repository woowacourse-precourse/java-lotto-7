package lotto.service;

import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoService {
    public WinningLotto create(String winningNumbersInput, int bonusNumber){
        Lotto winningNumbers = parseLotto(winningNumbersInput);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto parseLotto(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어있습니다.");
        }
    }
}

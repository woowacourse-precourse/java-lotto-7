package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ConstantMessage.ErrorMessage;
import lotto.utils.ConstantValue;

public class InputView {
    public int inputPrice() {
        try {
            int price = Integer.parseInt(Console.readLine());
            if (price <= 0 || price % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return price;
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

    public List<Integer> inputWinningNumbers() {
        try {
            List<Integer> winning = inputLottoNumbers();
            if (winning.size() != ConstantValue.LOTTO_NUMBER_COUNT) {
                throw new IllegalArgumentException();
            }
            return winning;
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        try {
            return inputLottoNumber(winningNumbers);
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

    private int inputLottoNumber(List<Integer> winningNumbers) {
        String sentence = Console.readLine();
        int value = Integer.parseInt(sentence);
        if (winningNumbers.contains(value)
                || value < ConstantValue.LOTTO_MIN_VALUE
                || value > ConstantValue.LOTTO_MAX_VALUE
        ) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
        return value;
    }

    private List<Integer> inputLottoNumbers() {
        String sentence = Console.readLine();
        return Arrays.stream(sentence.split(","))
                .map(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
                .collect(Collectors.toList());
    }
}

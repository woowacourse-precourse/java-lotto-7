package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ConstantMessage.ErrorMessage;
import lotto.utils.Validator;

public class InputView {
    Validator validator;

    public InputView() {
        validator = new Validator();
    }

    public int inputPrice() {
        try {
            int price = Integer.parseInt(Console.readLine());
            validator.validatePrice(price);
            return price;
        } catch (IllegalArgumentException | IllegalStateException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

    public List<Integer> inputWinningNumbers() {
        try {
            List<Integer> winning = inputLottoNumbers();
            validator.validateLottoNumber(winning);
            return winning;
        } catch (IllegalArgumentException | IllegalStateException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }

    public int inputLottoNumber(List<Integer> winningNumbers) {
        try {
            String sentence = Console.readLine();
            int value = Integer.parseInt(sentence);
            validator.validateLottoNumber(value);
            validator.validateDuplicated(winningNumbers, value);
            return value;
        } catch (IllegalArgumentException | IllegalStateException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }
    }


    private List<Integer> inputLottoNumbers() {
        String sentence = Console.readLine();
        return Arrays.stream(sentence.split(","))
                .map(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
                .collect(Collectors.toList());
    }
}

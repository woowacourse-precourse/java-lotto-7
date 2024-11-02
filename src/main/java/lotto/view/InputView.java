package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ConstantMessage.ErrorMessage;

public class InputView {
    public int inputPrice() {
        String sentence = Console.readLine();
        int price = Integer.parseInt(sentence);
        if (price <= 0 || price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getErrorMessage());
        }
        return price;
    }

    public List<Integer> inputLottoNumbers() {
        String sentence = Console.readLine();
        return Arrays.stream(sentence.split(","))
                .map(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String sentence = Console.readLine();
        return Integer.parseInt(sentence);
    }
}

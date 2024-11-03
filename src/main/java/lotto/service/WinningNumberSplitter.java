package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class WinningNumberSplitter {

    private static final String NUMBER_DELIMITER = ",";

    public Lotto split(String winningLottoNumber) {
        List<Integer> numbers = Arrays.stream(winningLottoNumber.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}

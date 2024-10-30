package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.domain.WinningNumbers;

public class WinningNumbersService {

    public WinningNumbers createWinningNumbers(String input){
        return new WinningNumbers(convertToIntegerList(input));
    }

    private List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(LottoConstant.LOTTO_NUMBER_INPUT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}

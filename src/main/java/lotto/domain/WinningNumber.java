package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningNumber extends Lotto {

    public WinningNumber(List<Integer> numbers) {
        super(numbers);
    }

    public static WinningNumber parseWinningNumber(String input) {
        List<String> inputItems = Arrays.asList(input.split(","));
        List<Integer> lottoNumbers = inputItems.stream()
                .map(LottoNumber::parseLottoNumber)
                .map(LottoNumber::getNumber)
                .toList();
        return new WinningNumber(lottoNumbers);
    }
}

package lotto.domain;

import static lotto.prompt.LottoDrawPrompt.WINNING_NUMBER_SPLIT_REGEX;

import java.util.Arrays;
import java.util.List;

public class WinningNumber extends Lotto {

    public WinningNumber(List<Integer> numbers) {
        super(numbers);
    }

    public static WinningNumber parse(String input) {
        List<String> inputItems = Arrays.asList(input.split(WINNING_NUMBER_SPLIT_REGEX));
        List<Integer> lottoNumbers = inputItems.stream()
                .map(String::trim)
                .map(LottoNumber::parseLottoNumber)
                .map(LottoNumber::getNumber)
                .toList();
        return new WinningNumber(lottoNumbers);
    }
}

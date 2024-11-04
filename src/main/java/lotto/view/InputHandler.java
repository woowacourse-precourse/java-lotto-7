package lotto.view;

import static lotto.resources.Constants.COMMA;

import java.util.Arrays;
import java.util.List;
import lotto.domain.number.Numbers;

public class InputHandler {
    public int stringToNumber(final String input) {
        return Integer.parseInt(input);
    }

    public Numbers splitLottoNumbers(final String input) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .map(this::stringToNumber)
                .toList();

        return Numbers.of(lottoNumbers);
    }
}

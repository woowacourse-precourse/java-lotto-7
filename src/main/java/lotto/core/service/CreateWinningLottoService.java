package lotto.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.commons.numbers.Integers;
import lotto.core.constants.Error.WinningLottoError;
import lotto.core.dto.LottoDto;
import lotto.core.model.Lotto;

public class CreateWinningLottoService {

    public LottoDto create(String value) {
        validateValue(value);

        List<Integer> numbers = this.mapToNumbers(value);

        Lotto lotto = new Lotto(numbers);

        return LottoDto.modelOf(lotto);
    }

    private void validateValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(WinningLottoError.REQUIRED_NUMBER);
        }
    }

    private List<Integer> mapToNumbers(String value) {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(value, ",");
        while (tokenizer.hasMoreTokens()) {
            numbers.add(Integers.parseIntOrThrow(tokenizer.nextToken(), WinningLottoError.INVALID_NUMBER_FORMAT));
        }
        return numbers;
    }
}

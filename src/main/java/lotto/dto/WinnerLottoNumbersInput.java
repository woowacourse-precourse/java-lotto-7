package lotto.dto;

import lotto.validator.DTOValidator;

public record WinnerLottoNumbersInput(String rawNumbers) {

    private static final DTOValidator validator = new DTOValidator();

    public static WinnerLottoNumbersInput from(String rawNumbers) {
        validator.NotNull(rawNumbers);
        validator.Empty(rawNumbers);

        return new WinnerLottoNumbersInput(rawNumbers);
    }
}

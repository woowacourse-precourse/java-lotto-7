package lotto.dto;

import lotto.validator.DTOValidator;

public record WinnerLottoNumbersInput(String rawNumbers) {

    private static final DTOValidator dTOValidator = new DTOValidator();

    public static WinnerLottoNumbersInput from(String rawNumbers) {
        dTOValidator.NotNull(rawNumbers);
        dTOValidator.Empty(rawNumbers);
        return new WinnerLottoNumbersInput(rawNumbers);
    }
}

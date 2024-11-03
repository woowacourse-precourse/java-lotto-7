package lotto.dto;

import lotto.validator.DTOValidator;

public record BonusLottoNumBerInput(String rawNumber) {

    private static final DTOValidator dTOValidator = new DTOValidator();

    public static BonusLottoNumBerInput from(String rawNumber) {
        dTOValidator.NotNull(rawNumber);
        dTOValidator.Empty(rawNumber);
        return new BonusLottoNumBerInput(rawNumber);
    }
}

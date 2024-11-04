package lotto.dto;

import lotto.validator.DTOValidator;

public record BonusLottoNumberInput(String rawNumber) {

    private static final DTOValidator validator = new DTOValidator();

    public static BonusLottoNumberInput from(String rawNumber) {
        validator.NotNull(rawNumber);
        validator.Empty(rawNumber);

        return new BonusLottoNumberInput(rawNumber);
    }
}

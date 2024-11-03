package lotto.handler.rank.validation;

import java.util.List;

public class WinningNumberValidatorFactory {
    public List<WinningNumberValidator> create() {
        return List.of(
                new WinningNumberFormatValidator(),
                new WinningNumberCountValidator(),
                new WinningNumberRangeValidator(),
                new BonusNumberFormatValidator(),
                new BonusNumberRangeValidator(),
                new AllNumberDuplicateValidator()
        );
    }
}

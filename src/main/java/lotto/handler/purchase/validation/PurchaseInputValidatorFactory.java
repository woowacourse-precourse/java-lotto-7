package lotto.handler.purchase.validation;

import java.util.List;

public class PurchaseInputValidatorFactory {
    public List<PurchaseInputValidator> create() {
        return List.of(
                new PurchaseInputFormatValidator(),
                new PurchaseInputRangeValidator(),
                new PurchaseInputUnitValidator());
    }
}

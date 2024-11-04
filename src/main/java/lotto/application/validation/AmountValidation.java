package lotto.application.validation;

public interface AmountValidation extends BaseValidation{
    int validateAndParseAmount(String amountInput);
}

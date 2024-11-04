package lotto.validator;

public class ValidatorFacade {
    private final Validator<String> bonusNumberInputValidator;
    private final Validator<String> costInputValidator;
    private final Validator<Integer> costValidator;
    private final Validator<String> numbersInputValidator;

    public ValidatorFacade(Validator<String> bonusNumberInputValidator,
                           Validator<String> costInputValidator,
                           Validator<Integer> costValidator,
                           Validator<String> numbersInputValidator) {
        this.bonusNumberInputValidator = bonusNumberInputValidator;
        this.costInputValidator = costInputValidator;
        this.costValidator = costValidator;
        this.numbersInputValidator = numbersInputValidator;
    }

    public void validateBonusNumberInput(String input) {
        bonusNumberInputValidator.validate(input);
    }

    public void validateCostInput(String input) {
        costInputValidator.validate(input);
    }

    public void validateCost(Integer cost) {
        costValidator.validate(cost);
    }

    public void validateNumbersInput(String input) {
        numbersInputValidator.validate(input);
    }
}

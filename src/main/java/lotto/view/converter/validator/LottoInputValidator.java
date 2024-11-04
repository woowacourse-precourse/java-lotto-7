package lotto.view.converter.validator;

public class LottoInputValidator {

    private final LottoMoneyValidator lottoMoneyValidator;
    private final DefaultValidator defaultValidator;

    public LottoInputValidator() {
        this.lottoMoneyValidator = new LottoMoneyValidator();
        this.defaultValidator = new DefaultValidator();
    }

    public void validateMoney(String money) {
        lottoMoneyValidator.validate(money);
    }

    public void validateNumberFromString(String input) {
        defaultValidator.validateNumberFromString(input);
    }

}

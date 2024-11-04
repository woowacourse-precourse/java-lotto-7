package lotto.service;

public class LottoInputValidator {

    private LottoMoneyValidator lottoMoneyValidator;
    private DefaultValidator defaultValidator;

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

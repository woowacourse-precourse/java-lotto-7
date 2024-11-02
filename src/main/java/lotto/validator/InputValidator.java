package lotto.validator;

public class InputValidator {
    public void validate(String lottoPrice) {
        validateEmpty(lottoPrice);
        validateNumber(lottoPrice);
        validateForm(lottoPrice);
    }

}

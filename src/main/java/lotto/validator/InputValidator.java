package lotto.validator;

import lotto.util.Constants;

public interface InputValidator {
    public void validateCostForm(int price);

    public int validateNumber(String string);

    public void validateNumberRange(int number);

    public void validateEmpty(String string);

    public void validateNumbersForm(String string);
}

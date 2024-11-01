package lotto.view;

import lotto.utils.validator.InputValidator;
import lotto.utils.validator.Validator;

public class MemberInputView extends InputView {

    public Validator<String> validator;
    public MemberInputView() {
        this.validator = new InputValidator();
    }

    public int getPrice() {
        String inputPrice = readInput();
        validator.validate(inputPrice);

        return Integer.parseInt(inputPrice);
    }

}

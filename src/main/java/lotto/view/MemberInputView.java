package lotto.view;

import lotto.utils.InputValidator;
import lotto.utils.Validator;

public class MemberInputView extends InputView {

    private final Validator<String> validator;
    public MemberInputView() {
        this.validator = new InputValidator();
    }

    public int getPrice() {
        String inputPrice = readInput();
        validator.validate(inputPrice);
        return Integer.parseInt(inputPrice);
    }

}

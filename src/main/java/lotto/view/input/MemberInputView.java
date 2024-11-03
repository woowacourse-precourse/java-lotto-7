package lotto.view.input;

import lotto.utils.validator.InputValidator;
import lotto.utils.validator.Validator;

public class MemberInputView extends InputView {

    public Validator<String> validator;

    public MemberInputView() {
        this.validator = new InputValidator();
    }


    public int getPrice() {
        String inputPrice = readInput();
        try {
            validator.validate(inputPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrice();
        }

        return Integer.parseInt(inputPrice);
    }

}

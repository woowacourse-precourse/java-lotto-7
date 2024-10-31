package lotto.view;

import lotto.utils.Validator;

public class MemberInputView extends InputView {

    private final Validator<String> validator;
    public MemberInputView(Validator<String> validator) {
        this.validator = validator;
    }


    public int getPrice() {
        String inputPrice = readInput();
        validator.validate(inputPrice);
        return Integer.parseInt(inputPrice);
    }

}

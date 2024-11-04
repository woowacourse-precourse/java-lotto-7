package lotto.view;

import lotto.error.Error;

public class WinningNumbersView extends InputView {

    @Override
    public void validate(String input) {
        String[] strings = input.split(",");

        for (String str: strings) {
            isNumeric(str);
        }
    }

    private void isNumeric(String str) {
        try {
            Integer.parseInt(str);

        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_A_NUMBER.getMessage());
        }
    }
}

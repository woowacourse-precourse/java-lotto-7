package lotto.view;

import static lotto.util.Constants.*;

public class OutputView {

    public void printStartMessage() {
        System.out.println(LOTTO_START.getMessage());
    }

    public void printCountMessage() {
        System.out.println(LOTTO_COUNT.getMessage());
    }

    public void printErrorNumMessage() {
        System.out.println(ERROR_START.getMessage() + ERROR_NUMBER.getMessage());
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
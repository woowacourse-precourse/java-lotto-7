package lotto.view;

import lotto.constant.ExceptionMessage;

public class OutputView {

    public void printErrorMessage(String errorMessage) {
        System.out.println(ExceptionMessage.EXCEPTION_PREFIX + errorMessage);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void print(String s) {
        System.out.println(s);
    }
}

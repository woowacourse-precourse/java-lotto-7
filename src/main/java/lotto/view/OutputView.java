package lotto.view;

import java.math.BigInteger;

public class OutputView {

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printNumberOfLotto(BigInteger numberOfLotto) {
        PromptMessage.printLottoCount(numberOfLotto);
    }
}

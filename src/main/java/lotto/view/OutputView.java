package lotto.view;

import lotto.exception.LottoGameException;

public class OutputView {

    public void commentErrorMessage(LottoGameException e) {
        System.out.println(e.getMessage());
    }

}

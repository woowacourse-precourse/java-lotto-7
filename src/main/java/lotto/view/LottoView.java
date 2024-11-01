package lotto.view;

import lotto.model.InputModel;

public class LottoView {
    InputModel inputModel;

    public LottoView() {
        inputModel = new InputModel();
    }

    public int inputPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
        return (inputModel.getPrice())/1000;
    }
}

package lotto.view;

import lotto.util.messages.InputMessage;

public class InputView {
    public void printInputPurchasePrice() {
        System.out.println(InputMessage.INPUT_PURCHASE_PRICE.getMessage());
    }

    public void printInputLottoNumber() {
        System.out.println(InputMessage.INPUT_LOTTO_NUMBER.getMessage());
    }

    public void printInputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
    }
}

package lotto.view;

import lotto.enums.lotto.LottoMessage;

public class InputView {

    public void printInputLottoPurchaseAmount(){
        System.out.println(LottoMessage.PRINT_INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
    }

    public void printInputBonusNumber(){
        System.out.println(LottoMessage.PRINT_INPUT_BONUS_NUMBER.getMessage());
    }

    public void printInputWinningNumber(){
        System.out.println(LottoMessage.PRINT_INPUT_WINNING_NUMBER.getMessage());
    }
}

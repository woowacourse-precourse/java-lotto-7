package lotto.view;

import lotto.enums.lotto.LottoMessage;

public class InputView {

    public void printInputLottoParchaseAmount(){
        System.out.println(LottoMessage.PRINT_LOTTO_PURCHASE_AMOUNT.getMessage());
    }
    
    public void printInputBonusNumber(){
        System.out.println(LottoMessage.PRINT_BONUS_NUMBER.getMessage());
    }

    // TODO: 당첨 번호 입력화면을 출력한다.

}

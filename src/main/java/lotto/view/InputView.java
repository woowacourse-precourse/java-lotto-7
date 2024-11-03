package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Amount;

import static lotto.constant.Amount.THOUSAND;

public class InputView {

    public String receivePurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String receiveWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }


    public String receiveBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

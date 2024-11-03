package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.UserInterfaceMessage;

public class LottoView {

    public void guideInputMoney(){
        System.out.println(UserInterfaceMessage.GUIDE_INPUT_MONEY);
    }

    public String readMoney(){
        this.guideInputMoney();
        String money = Console.readLine();
        return money;
    }
}

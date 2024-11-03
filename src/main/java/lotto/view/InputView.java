package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String enterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputValue();
    }

    public String inputValue(){
        return Console.readLine();
    }

}

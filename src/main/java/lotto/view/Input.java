package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String pay() {
        System.out.println("구입금액을 입력해 주세요.");
        return getInputValue();
    }
    
    private String getInputValue() {
        return Console.readLine();
    }
}

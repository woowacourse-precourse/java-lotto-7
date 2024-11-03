package store.view;

import camp.nextstep.edu.missionutils.Console;

public class StoreInputView {

    public String inputWeeklyNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        return Console.readLine();
    }
}

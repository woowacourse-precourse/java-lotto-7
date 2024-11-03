package store.view;

import camp.nextstep.edu.missionutils.Console;

public class StoreInputView {

    public String inputWeeklyNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        return Console.readLine();
    }
}

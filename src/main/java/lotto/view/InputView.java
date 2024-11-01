package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int readMoney() {
        String input = readLine();
        try {
            return convertInputToMoney(input);
        } catch(IllegalArgumentException e) {
            //Todo: 입력 요구 메시지 추가
            return readMoney();
        }
    }

    private static int convertInputToMoney(String input) throws IllegalArgumentException {
        int money = Integer.parseInt(input);
        if(money < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0원 이상을 입력해주세요.");
        }
        return money;
    }
}

package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class InputView {

    public int getPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();

        while (!validate(money)) {
            System.out.println("옳바른 구입금액을 입력해 주세요.");
            money = readLine();
        }
        return parseInt(money);
    }

    // TODO: 로직 개선 필요
    private boolean validate(String money) {
        try {
            if (parseInt(money) % 1000 != 0) {
                System.out.println("[ERROR] 구입금액은 1,000원 단위입니다.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위입니다.");
            return false;
        }
    }

}

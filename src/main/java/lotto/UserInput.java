package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {
    private final Service lottoService;
    public UserInput(Service lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int money = getValidMoney();
        lottoService.buyLotto(money);
        lottoService.printLotto();

        Lotto userNum = getUserNumber();
        int bonusNum = getBonusNumber();

        lottoService.calculate(userNum, bonusNum);
        lottoService.printResult(money);
    }

    private int getValidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int validate = 0;

        try {
            validate = lottoService.isValid(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        return validate;
    }

    private Lotto getUserNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return lottoService.validNum(input);
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        return lottoService.validBonusNum(input);
    }
}


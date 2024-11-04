package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInputConverter {

    public int getCost() {
        boolean validated = false;
        String userInput = "";
        System.out.println("구입금액을 입력해 주세요.");
        while (!validated) {
            try {
                userInput = Console.readLine();
                validated = validateCost(userInput);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(userInput);
    }

    private boolean validateCost(String userInput) {
        int cost = 0;
        try {
            cost = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 로또 구입 금액은 0 이상의 1000원 단위 이어야 합니다.");
        }
        if (cost < 0 || cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0 이상의 1000원 단위 이어야 합니다.");
        }
        return true;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userWinningNumbers = Console.readLine();
        return Arrays.stream(userWinningNumbers.split(",")).map(Integer::parseInt).toList();
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String userBonusNumber = Console.readLine();
        return Integer.parseInt(userBonusNumber);
    }
}

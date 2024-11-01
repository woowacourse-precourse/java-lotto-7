package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    //사용자에게 구입금액 입력받는 메소드
    public int inputPurchasePrice() {
        try {
            System.out.println("구입금액을 입력해주세요");
            String input = Console.readLine();

            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요.");
            }
            return Integer.parseInt(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchasePrice();
        }

    }
    //사용자에게 당첨번호 받는 로직
    public String[] setWinningNumber() {
        System.out.println("당첨 번호를 쉼표로 구분해 입력해 주세요 당첨번호는 1~45까지 6자리 수 입니다");
        return Console.readLine().split(",");
    }
    //사용자에게 보너스 번호 받는 로직
    public int setBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요");
            String bonusNumber = Console.readLine();

            if (!bonusNumber.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요.");
            }

            return Integer.parseInt(bonusNumber);

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setBonusNumber();
        }

    }
}

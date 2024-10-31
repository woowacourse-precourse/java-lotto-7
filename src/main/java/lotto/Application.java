package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputMoney;
        while (true){
            try {
                System.out.println("구입금액을 입력해 주세요.");
                inputMoney = Console.readLine();
                moneyErrorCheck(inputMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
    public static void moneyErrorCheck(String inputMoney){
        int money;
        try {
            money = Integer.parseInt(inputMoney);
            if (money < 1000 ) {
                throw new IllegalArgumentException("[ERROR] 1000원 이하의 금액 입니다.");
            } else if (money%1000 !=0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위 금액을 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }
}

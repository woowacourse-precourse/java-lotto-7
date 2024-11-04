package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class PurchasingInput {

    private PurchasingInput() {}

    public static Integer getCost() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();

                Integer cost = makeNumber(input);

                if (cost % 1000 != 0) {
                    System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
                    continue;
                }

                return cost;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식만 입력 가능합니다.");
            }
        }
    }

    public static Integer makeNumber(String input){
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 변환할 수 없는 값입니다.");
            return 1;
        }
    }
}
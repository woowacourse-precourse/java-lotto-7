package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Price price = null;
        while (price == null) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                price = Price.from(input);
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + "문자가 입력됐거나, 숫자 범위를 초과하였습니다.");
            }
        }

    }
}

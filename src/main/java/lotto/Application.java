package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입 가격을 입력해주세요.");
        int price = Integer.parseInt(Console.readLine());

        System.out.println("당첨번호를 입력해주세요.");
        String winnigNumber = Console.readLine();

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumber = Console.readLine();
    }
}

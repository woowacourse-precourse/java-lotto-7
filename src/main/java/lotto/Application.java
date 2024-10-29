package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);

        // 구입 횟수 만큼 로또 구매
        int count = amount / 1000;
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }
}

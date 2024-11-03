package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        String buy = Console.readLine();  // 구입 금액

        System.out.println("당첨 번호를 입력해 주세요.");
        String lotto = Console.readLine(); // 당첨 번호

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine(); // 보너스 번호
    }
}

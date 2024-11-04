package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        return amount;
    }

    private static List<Integer> getInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim().split(",");
    }

    private static int getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    public static int getCost() {
//        System.out.println("구입금액을 임력해 주세요.");
        System.out.println("Input Purchase Cost");
        return Integer.parseInt(Console.readLine());
    }

    public static String getWinNumbers() {
//        System.out.println("당첨 번호를 입력해 주세요.");
        System.out.println("Input Win Numbers");
        return Console.readLine();
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
//        System.out.println("보너스 번호를 입력해 주세요");
        System.out.println("Input Bonus Number");
        int num = 0;
        boolean check = true;

        while (check) {
            num = Integer.parseInt(Console.readLine());
            if (winningNumbers.contains(num)) {
                System.out.println("중복이 발생되었습니다 : " + num);
                continue;
            }
            check = false;
        }
        return num;
    }
}

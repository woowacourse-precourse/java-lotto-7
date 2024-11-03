package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IO {
    public String readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printResult(double result) {
        System.out.println("당첨통계\n---");
        // TODO: 당첨 통계 출력 (n개 일치)
        System.out.printf("총 수익률은 %f입니다", result);
    }
}

package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public int readPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하지 않았습니다.");
        }
    }

    public String readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int readBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하지 않았습니다.");
        }
    }

    public void close() {
        Console.close();
    }
}

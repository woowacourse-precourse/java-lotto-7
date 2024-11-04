package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public int readPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            long input = Long.parseLong(Console.readLine());
            if (input > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("[ERROR] 구매할 수 있는 최대 금액을 초과했습니다.");
            }
            return (int) input;
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
            System.out.println("\n보너스 번호를 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하지 않았습니다.");
        }
    }

    public void close() {
        Console.close();
    }
}

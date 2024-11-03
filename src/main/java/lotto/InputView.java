package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getAmountToBuy() {
        while (true) {
            try {
                String input = Console.readLine();
                int amountToBuy = Integer.parseInt(input); // 숫자가 아닌 경우 NumberFormatException 발생
                if (amountToBuy % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 1,000원으로 나누어 떨어져야 합니다.");
                }
                return amountToBuy;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

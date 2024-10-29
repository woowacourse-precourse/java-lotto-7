package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {

		while (true) {
			try {
				System.out.println("구입금액을 입력해 주세요.");
				String amount = Console.readLine();
				Amount amountCheck = new Amount(amount);
			} catch (IllegalArgumentException e) {
				System.err.println("[ERROR] 숫자만 입력해주세요.");
			}
		}

	}
}

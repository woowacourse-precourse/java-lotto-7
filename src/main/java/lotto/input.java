package lotto;

import camp.nextstep.edu.missionutils.Console;

public class input {
	public int put_money() {
		System.out.println("구입금액을 입력해 주세요.");
		String put_money = Console.readLine();
		int count = 0;
		try {
			paymentEx2(put_money);
			int money = Integer.parseInt(put_money);
			count = try_number(money);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			put_money();
		}
		return count;
	}

	public int try_number(int money) {
		int count = money / 1000;
		int trash = money % 1000;
		try {
			paymentEx(trash, money);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			put_money();
		}
		return count;
	}

	public void paymentEx(int trash, int money) {
		if (trash != 0) {
			throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
		}
	}

	public void paymentEx2(String input) {
		for (char ch : input.toCharArray()) {
			int asciiValue = (int) ch;
			if (asciiValue < 48 || asciiValue > 57) {
				throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
			}
		}
	}
}

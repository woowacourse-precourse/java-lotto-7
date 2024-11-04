package lotto;

import camp.nextstep.edu.missionutils.Console;

public class input {
	public int put_money() {
		System.out.println("구입금액을 입력해 주세요.");
		String put_money = Console.readLine();
		int count = 0;
		try {
			int money = Integer.parseInt(put_money);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			put_money();
		}
		return count;
	}
}

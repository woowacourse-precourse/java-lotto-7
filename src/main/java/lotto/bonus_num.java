package lotto;

import camp.nextstep.edu.missionutils.Console;

public class bonus_num {
	public int second() {
		System.out.println("보너스 번호를 입력해주세요.");
		int second = 0;
		String second_num = Console.readLine();
		try {
			second = Integer.parseInt(second_num);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			second();
		}
		return second;
	}
}
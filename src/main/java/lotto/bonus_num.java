package lotto;

import camp.nextstep.edu.missionutils.Console;

public class bonus_num {
	public int second() {
		System.out.println("보너스 번호를 입력해주세요.");
		int second = 0;
		String second_num = Console.readLine();
		try {
			secondEx(second_num);
			second = Integer.parseInt(second_num);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			second();
		}
		return second;
	}

	public void secondEx(String second_num) {
		for (char ch : second_num.toCharArray()) {
			int asciiValue = (int) ch;
			if (asciiValue < 48 || asciiValue > 57 || Integer.parseInt(second_num)>45) {
				throw new IllegalArgumentException("[ERROR] 45이하의 숫자만 입력해주세요.");
			}
		}
	}
}
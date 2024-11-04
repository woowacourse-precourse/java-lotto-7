package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Win_Num {
	public List<Integer> winArr() {
		System.out.println("당첨 번호를 입력해주세요.");
		List<Integer> winList = new ArrayList<>();
		String putWinNum = Console.readLine();

		if (putWinNum.contains(",")) {
			String[] arr = putWinNum.split(",");
			try {
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return winArr();
			}
			try {
			} catch (IllegalArgumentException e2) {
				System.out.println(e2.getMessage());
				return winArr();
			}

			for (int i = 0; i < 6; i++) {
				winList.add(Integer.parseInt(arr[i].trim()));
			}
			try {
			} catch (IllegalArgumentException e3) {
				System.out.println(e3.getMessage());
				return winArr();
			}
			return winList;
		}
		return winArr();
	}


}
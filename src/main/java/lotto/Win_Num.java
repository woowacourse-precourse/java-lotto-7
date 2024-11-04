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
				putNumEx(arr);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return winArr();
			}
			try {
				putNumEx2(arr);
			} catch (IllegalArgumentException e2) {
				System.out.println(e2.getMessage());
				return winArr();
			}

			for (int i = 0; i < 6; i++) {
				winList.add(Integer.parseInt(arr[i].trim()));
			}
			try {
				putNumEx3(winList);
			} catch (IllegalArgumentException e3) {
				System.out.println(e3.getMessage());
				return winArr();
			}
			return winList;
		}
		return winArr();
	}

	public void putNumEx(String[] arr) {
		if (arr.length != 6) {
			throw new IllegalArgumentException("[ERROR]당첨 숫자 6개를 입력해주세요.");
		}
	}

	public void putNumEx2(String[] arr) {
		for (int i = 0; i < 6; i++) {
			if (Integer.parseInt(arr[i]) > 45) {
				throw new IllegalArgumentException("[ERROR]45이하의 당첨 숫자 6개를 입력해주세요.");
			}
		}
	}

	public void putNumEx3(List<Integer> winList) {
		for (int i = 0; i < winList.size() - 1; i++) {
			if (winList.get(i).equals(winList.get(i + 1))) {
				throw new IllegalArgumentException("[ERROR]중복되지 않은 당첨 숫자 6개를 입력해주세요.");
			}
		}

	}
}
package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

	private String winning;
	private List<Integer> winningList = new ArrayList<>();

	public WinningNumber(String winning) {
		this.winning = winning;
	}

	public List<Integer> winningCheck() {
		String[] winningArr = winningSplit();
		winningList(winningArr);
		return winningList;
	}

	private String[] winningSplit() {
		return winning.split(",");
	}

	private void winningList(String[] winningArr) {
		for (int i = 0; i < winningArr.length; i++) {
			int num = numberCheck(winningArr[i]);
			winningList.add(num);
		}
	}

	private int numberCheck(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException ne) {
			throw new NumberFormatException("[ERROR] 숫자만 입력해주세요.");
		}
	}

}

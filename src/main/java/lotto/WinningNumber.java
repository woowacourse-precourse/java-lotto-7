package lotto;

import java.util.LinkedHashSet;
import java.util.Set;

public class WinningNumber {

	private String winning;
	private Set<Integer> set = new LinkedHashSet<>();

	public WinningNumber(String winning) {
		this.winning = winning;
	}

	public void winningCheck() {
		String[] winningArr = winningSplit();
		valueCheck(winningArr);
		duplicationCheck(winningArr.length);
	}

	private String[] winningSplit() {
		return winning.split(",");
	}

	private void valueCheck(String[] winningArr) {
		lengthCheck(winningArr.length);
		for (String s : winningArr) {
			int num = numberCheck(s);
			numberScope(num);
			duplication(num);
		}
	}

	private void lengthCheck(int length) {
		if (length != 6) {
			throw new NumberFormatException("[ERROR] 로또 번호는 6개를 입력해주세요.");
		}
	}

	private int numberCheck(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException ne) {
			throw new NumberFormatException("[ERROR] 숫자만 입력해주세요.");
		}
	}

	private void numberScope(int num) {
		if (num < 1) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
		if (num > 45) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
	}

	private void duplication(int num) {
		set.add(num);
	}

	private void duplicationCheck(int length) {
		if (length != set.size()) {
			throw new NumberFormatException("[ERROR] 중복값은 입력할 수 없습니다.");
		}
	}
}

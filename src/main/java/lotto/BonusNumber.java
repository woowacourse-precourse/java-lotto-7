package lotto;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber {

	private static int bonus;
	private static List<Integer> winningList = new ArrayList<>();

	public BonusNumber(String bonus, List<Integer> winningList) {
		BonusNumber.bonus = numberCheck(bonus);
		BonusNumber.winningList = winningList;
	}

	public void bounsCheck() {
		numberScope();
		duplication();
	}

	private int numberCheck(String bonus) {
		try {
			return Integer.parseInt(bonus);
		} catch (NumberFormatException ne) {
			throw new NumberFormatException("[ERROR] 숫자만 입력해주세요.");
		}
	}

	private static void numberScope() {
		if (getBonus() < 1) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
		if (getBonus() > 45) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
	}

	private static void duplication() {
		for (int i = 0; i < winningList.size(); i++) {
			if (winningList.get(i) == getBonus()) {
				throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복값을 입력할 수 없습니다.");
			}
		}
	}

	public static int getBonus() {
		return bonus;
	}

}

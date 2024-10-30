package lotto;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber {
	
	private int bonus;
	private List<Integer> winningList = new ArrayList<>();
	
	public BonusNumber(String bonus, List<Integer> winningList) {
		this.bonus = numberCheck(bonus);
		this.winningList = winningList;
	}

	public int bounsCheck() {
		numberScope();
		duplication();
		return 0;
	}
	
	private int numberCheck(String bonus) {
		try {
			return Integer.parseInt(bonus);
		} catch (NumberFormatException ne) {
			throw new NumberFormatException("[ERROR] 숫자만 입력해주세요.");
		}
	}

	private void numberScope() {
		if (bonus < 1) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
		if (bonus > 45) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이로 입력해주세요.");
		}
	}
	
	private void duplication() {
		for(int i = 0; i < winningList.size(); i++) {
			if(winningList.get(i) == bonus) {
				throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복값을 입력할 수 없습니다.");
			}
		}
	}

}

package lotto.answer;

import java.util.List;
import lotto.Lotto;

public class Answer {
	private Lotto answerLotto;
	private int bonusLotto;

	public Answer(Lotto answerLottos, int bonusLotto) {
		this.answerLotto = answerLottos;
		this.bonusLotto = bonusLotto;
	}

	public int checkLottoResult(Lotto pickedLotto) {
		List<Integer> pickedLottoNumber = pickedLotto.getNumbers();
		pickedLottoNumber.retainAll(answerLotto.getNumbers());
		return pickedLottoNumber.size();
	}

	public boolean hasBonusLotto(Lotto pickedLotto) {
		return pickedLotto.getNumbers().contains(bonusLotto);
	}
}

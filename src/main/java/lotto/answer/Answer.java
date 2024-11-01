package lotto.answer;

import lotto.Lotto;

public class Answer {
	private Lotto answerLotto;
	private int bonusLotto;

	public Answer(String answerLotto, String bonusLotto) {
		this.bonusLotto = Integer.parseInt(bonusLotto);
	}
}

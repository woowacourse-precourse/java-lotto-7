package lotto.validator;

import lotto.answer.Answer;
import lotto.provider.LottoProvider;
import lotto.user.User;

public class Validator {
	private LottoProvider provider;
	private User user;

	private Answer answer;

	public Validator(LottoProvider provider, User user, Answer answer) {
		this.provider = provider;
		this.user = user;
		this.answer = answer;
	}
}

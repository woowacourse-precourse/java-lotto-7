package lotto.validator;

import java.util.HashSet;
import java.util.List;

import lotto.Lotto;
import lotto.answer.Answer;
import lotto.answer.LottoRank;
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

	public void validateLotto() {
		List<Lotto> pickedLottos = provider.getPickedLottos();
		for (Lotto lotto : pickedLottos) {
			int matchCounts = lotto.checkLottoResult(answer);
			boolean hasBonus = lotto.hasBonusLotto(answer);
			LottoRank rankByMatch = LottoRank.findRankByMatch(matchCounts, hasBonus);
			if (rankByMatch != null) {
				user.updateRank(rankByMatch);
			}
		}
	}
}

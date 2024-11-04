package lotto.view.convertor;

import lotto.dto.MatchResponse;
import lotto.dto.UserLotto;

public interface Convertor {
    String getMatchResult(MatchResponse matchResponse);

    String getPurchaseSign(UserLotto userLotto);

    String getUserLottos(UserLotto userLotto);
}

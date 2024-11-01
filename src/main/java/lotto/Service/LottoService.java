package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.GameInfo;
import lotto.Domain.LottoResult;
import lotto.Lotto;
import lotto.Constants.Error;
import lotto.View.OutputView;

/**
 * 로또 게임을 진행하는 서비스 클래스
 */
public class LottoService {

    public LottoService() {
    }

    /**
     * 로또를 생성하는 메서드. 로또머신에서 구입금액을 확인하고, 로또를 생성한다.
     * @param gameInfo
     * @return 생성된 로또
     */
    public Lotto generateLotto(GameInfo gameInfo) {
        if (gameInfo.getPurchaseAmount() <= 0) {
            throw new IllegalStateException(Error.LACK_OF_FUNDS.getText());
        }
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}

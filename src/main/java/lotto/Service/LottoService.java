package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.GameInfo;
import lotto.Lotto;
import lotto.Constants.Error;

/**
 * 로또 게임을 진행하는 서비스 클래스
 */
public class LottoService {

    public LottoService() {
    }

    /**
     * 로또를 생성하는 메서드. 게임정보에서 구입금액을 확인하고, 로또를 생성한다.
     * 로또를 생성할대 마다 게임정보의 remainingLottoAmount, 남은 로또의 수가 줄어든다
     *
     * @param gameInfo
     * @return 생성된 로또
     */
    public Lotto generateLotto(GameInfo gameInfo) {
        if (gameInfo.getRemainingLottoAmount() <= 0) {
            throw new IllegalStateException(Error.LACK_OF_FUNDS.getText());
        }
        gameInfo.decreaseRemainingAmount();
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}

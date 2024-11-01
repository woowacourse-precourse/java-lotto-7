package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.GameInfo;
import lotto.Domain.LottoResult;
import lotto.Lotto;
import lotto.Constants.Error;

/**
 * 로또 게임을 진행하는 서비스 클래스
 */
public class LottoService {

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

    /**
     * 로또를 구매하고 결과를 반환하는 메서드. 구입금액에 따라 로또를 생성하고, 당첨번호와 비교하여 결과를 반환한다.
     *
     * @param gameInfo 로또 구입 정보 및 당첨번호를 담은 객체
     * @param winningLotto 로또 당첨번호를 비교할 로또
     * @return 로또 결과
     */
    public LottoResult play(GameInfo gameInfo, Lotto winningLotto) {
        LottoResultService lottoResultService = new LottoResultService();

        while (gameInfo.getPurchaseAmount() > 0) {
            Lotto lotto = generateLotto(gameInfo);
            lottoResultService.checkLottoResult(winningLotto, lotto, gameInfo.getBonusNumber());
        }
        return lottoResultService.getLottoResult();
    }

}

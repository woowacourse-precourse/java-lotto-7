package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Domain.GameInfo;
import lotto.Lotto;
import lotto.Service.LottoService;
import lotto.View.InputView;

/**
 * 로또 게임을 진행과 유저 입력을 담당하는 컨트롤러 클래스
 */
public class LottoController {
    private GameInfo gameInfo;
    private InputView inputView;
    private LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        getWinnerInfo();
        Console.close();
    }

    /**
     * 사용자로부터 입력을 받아 초기설정을 하는 프로시져
     */
    public void getWinnerInfo() {
        int purchaseAmount = inputView.getLottoPurchaseAmount();
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = inputView.getBonusNumber(winningLotto);
        gameInfo = new GameInfo(purchaseAmount, bonusNumber);
    }

    /**
     * 사용자로부터 입력받은 로또 번호를 Lotto 객체로 변환하는 함수
     * @return
     */
    private Lotto getWinningLotto() {
        List<Integer> lottoNumbers = inputView.getLottoNumbers();
        return new Lotto(lottoNumbers);
    }

}

package lotto.Controller;

import com.sun.tools.javac.Main;
import java.util.List;
import lotto.Domain.LottoMachine;
import lotto.Lotto;
import lotto.View.InputView;

public class MainController {
    private LottoMachine lottoMachine;
    private InputView inputView;

    public MainController (InputView inputView) {
        this.inputView = new InputView();
    }

    public void run() {
        promptUserInput();
    }

    /* 사용자로부터 입력을 받아 초기설정을 하는 프로시져 */
    private void promptUserInput() {
        int purchaseAmount = inputView.getLottoPurchaseAmount();
        Lotto playerLotto = getPlayerLotto();
        int bonusNumber = inputView.getBonusNumber(playerLotto);
        lottoMachine = new LottoMachine(purchaseAmount, bonusNumber, playerLotto);
    }

    /* 사용자로부터 입력받은 로또 번호를 Lotto 객체로 변환하는 함수 */
    private Lotto getPlayerLotto() {
        List<Integer> lottoNumbers = inputView.getLottoNumbers();
        try {
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        int inpuMoney = InputView.readInputMoney();
        Lotto winningLotto = new Lotto(InputView.readAndSplitWinningNumber());
        int bonusNumber = InputView.readBonusNumber(winningLotto);

        Lottos lottos = Lotto.buyAsMoney(inpuMoney);
        System.out.println(lottos.getLottos().size() + "개를 구매하셨습니다");
        lottos.printLottoNumber();
    }
}

package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseLotto;
import lotto.domain.User;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoService(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Lotto winningLottoNumbers() {
        try{
            return new Lotto(LottoNumberParser.parseLottoNumbers(inputView.inputWinningNumbers()));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return winningLottoNumbers();
        }
    }

    public Lotto bonusLottoNumbers(Lotto lotto) {
        try{
            lotto.addBonusNumber(inputView.inputBonusNumber());
            return lotto;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return bonusLottoNumbers(lotto);
        }
    }

    public void winningResult(User user, Lotto lotto) {
        LottoResult lottoResult = new LottoResult(user.getPurchaseLottos(), lotto);
        outputView.lottoResultView(lottoResult, user.getPurchaseAmount());
    }
}

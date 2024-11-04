package lotto.service;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.message.SystemMessage;

public class LottoCompany {
    private Lotto winningNumber;
    private Integer bonusNumber;
    private final InputView inputView = new InputView();

    public Lotto setWinningNumber() {
        this.winningNumber = new Lotto(inputView.lottoInput(SystemMessage.INPUT_WINNING_NUMBER.getMessage()));
        return winningNumber;
    }

    public Integer setBonusNumber(Lotto lotto) {
        this.bonusNumber = inputView.lottoNumberInput(SystemMessage.INPUT_BONUS_NUMBER.getMessage(), lotto);
        return bonusNumber;
    }
}

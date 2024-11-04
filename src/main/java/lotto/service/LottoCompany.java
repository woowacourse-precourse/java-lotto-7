package lotto.service;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Match;
import lotto.view.InputView;
import lotto.view.message.SystemMessage;

public class LottoCompany {
    private Lotto winningNumber;
    private Integer bonusNumber;
    private final InputView inputView = new InputView();

    public LottoCompany() {
    }

    public LottoCompany(Lotto winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto setWinningNumber() {
        this.winningNumber = new Lotto(inputView.lottoInput(SystemMessage.INPUT_WINNING_NUMBER.getMessage()));
        return winningNumber;
    }

    public Integer setBonusNumber(Lotto lotto) {
        this.bonusNumber = inputView.lottoNumberInput(SystemMessage.INPUT_BONUS_NUMBER.getMessage(), lotto);
        return bonusNumber;
    }

    public List<Match> getWinningStatics(List<Lotto> lotteries) {
        return lotteries.stream()
                .map(lotto -> Match.findMatch(lotto.countMatch(winningNumber), lotto.checkBonusMatch(bonusNumber))
                ).toList();
    }
}

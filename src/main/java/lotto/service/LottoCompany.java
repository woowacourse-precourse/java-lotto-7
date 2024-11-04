package lotto.service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import lotto.model.Lotto;
import lotto.model.Match;
import lotto.view.InputView;
import lotto.view.message.SystemMessage;

public class LottoCompany {
    private Lotto winningNumber;
    private Integer bonusNumber;
    private final Integer LOTTO_PRICE = 1000;
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

    public double calculateROI(List<Match> matches) {
        double investAmount = matches.size() * LOTTO_PRICE;
        double profit = matches.stream()
                .filter(Objects::nonNull)
                .map(match -> match.getMoney())
                .reduce(0, (a, b) -> a + b);
        BigDecimal bd = new BigDecimal(profit / investAmount * 100);
        bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

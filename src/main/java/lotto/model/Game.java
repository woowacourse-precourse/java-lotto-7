package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.model.purchase.LottoStore;
import lotto.utils.Constants;

public class Game {
    private final LottoStore lottoStore;
    private List<Lotto> issuedLottos = List.of();
    private WinningNumber winningNumber;

    public Game(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public void purchaseLottos(int amount) {
        issuedLottos = Collections.unmodifiableList(lottoStore.purchaseLottoTickets(amount));
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

    public void setWinningNumber(List<Integer> winningNumbers) {
        if (Objects.isNull(winningNumbers)) {
            winningNumber = new WinningNumber();
        }
        winningNumber.setWinningNumbers(new Lotto(winningNumbers));
    }

    public void setBonusNumber(int bonusNumber) {
        if (Objects.isNull(winningNumber) || winningNumber.getWinningNumbers() == null) {
            throw new IllegalStateException("당첨 번호가 먼저 설정되어야 합니다.");
        }
        winningNumber.setBonusNumber(new BonusNumber(bonusNumber, winningNumber.getWinningNumbers()));
    }

    private List<Ranking> calculateRankings() {
        if (Objects.isNull(winningNumber)) {
            throw new IllegalStateException("당첨 번호가 설정되지 않았습니다.");
        }
        return issuedLottos.stream()
                .map(winningNumber::getRanking)
                .toList();
    }

    private int calculateInvestmentCost() {
        return issuedLottos.size() * Constants.LOTTO_PRICE;
    }

    public WinningStatistics getResult() {
        return new WinningStatistics(calculateRankings(), calculateInvestmentCost());
    }
}

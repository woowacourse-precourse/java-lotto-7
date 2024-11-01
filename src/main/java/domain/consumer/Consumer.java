package domain.consumer;

import domain.lotto.Lotto;
import domain.lotto.LottoPrice;
import java.util.List;

public class Consumer {
    private List<Lotto> purchasedLottos;
    private Lotto selectWinnerLotto;
    private int bonusNumber;

    public int getQuantityPurchaseLottoBy(int money) {
        return money / LottoPrice.LOTTO_PRICE.getPrice();
    }

    public void receiveLottoTicket(List<Lotto> generatedLotto) {
        this.purchasedLottos = generatedLotto;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void selectWinnerNumbers(Lotto selectedWinnersNumbers) {
        this.selectWinnerLotto = selectedWinnersNumbers;
    }

    public void selectBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean selectedWinnerNumberIsEqualsTo(Lotto expectedLotto) {
        return selectWinnerLotto
                .getNumbers()
                .equals(expectedLotto.getNumbers());
    }

    public boolean selectedBonusNumberIsEqualsTo(int expectedBonusNumber) {
        return bonusNumber == expectedBonusNumber;
    }
    /**
     * 소비자는 돈을 소지하고 있는다.
     * 소비자는 로또를 저장할 수 있다.
     * 소비자는 로또를 구매하기 위해 돈을 지불한다.
     * 소비자는 자신이 입력한 당첨 번호를 저장하고 있어야 한다.
     */
}

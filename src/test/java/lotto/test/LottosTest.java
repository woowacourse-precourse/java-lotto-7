package lotto.test;

import java.util.ArrayList;
import java.util.List;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.Lottos;
import lotto.PurchaseAmount;
import lotto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("lotto들의 list를 담는 Lottos에서")
public class LottosTest {
    @Test
    @DisplayName("lotto게임의 결과를 반환한다")
    public void calculateGameResult() {
        //given
        List<Lotto> lotto = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        lotto.add(new Lotto(numbers));
        Lottos lottos = new Lottos(lotto);

        List<Integer> winningNumber = new ArrayList<>();
        for (int i = 4; i <= 9; i++) {
            winningNumber.add(i);
        }

        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        BonusNumber bonusNumber = new BonusNumber(3);
        bonusNumber.validateBonusNumberInRange();
        bonusNumber.validateBonusNumberNotDuplicate(winningNumbers);
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        //when
        LottoResult result = lottos.calculateGameResult(winningNumbers, bonusNumber);
        //then
        Assertions.assertThat(result.calculateEarningRate(purchaseAmount.getPurchasePrice())).contains("5000");
    }
}

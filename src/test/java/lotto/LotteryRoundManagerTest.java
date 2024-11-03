package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryRoundManagerTest {
    private final String ERROR_MESSAGE = "[ERROR] ";

    @DisplayName("로또의 구입은 1000원 단위로 이루어져야 한다.")
    @Test
    void 로또_구입_성공() {
        //given
        int cost = 8000;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when
        PurchasedLotto purchasedLotto = lotteryRoundManager.purchaseLotto(cost);

        //then
        assertThat(purchasedLotto.getSize()).isEqualTo(8);
    }

    @DisplayName("로또의 구입은 1000원 단위로 이루어져야 한다.")
    @Test
    void 로또_구입_1000원단위_X() {
        //given
        int cost = 8800;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.purchaseLotto(cost))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또의 구입은 0원 이상, 20억원 이하로 이루어져야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, 200001000})
    void 로또_구입_지나친_가격(int cost) {
        //given
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.purchaseLotto(cost))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 당첨번호는 겹치는 수가 없어야 한다.")
    @Test
    void 로또_당첨_번호는_겹치는_수가_없어야_한다() {
        //given
        List<Integer> wrongList = List.of(1, 1, 2, 3, 4, 5);
        int bonusNumber = 7;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.setWinningNumber(wrongList, bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 보너스번호는 당첨 번호와 겹치지 말아야 한다.")
    @Test
    void 로또_당첨_번호는_당첨_번호와_겹치지_말아야_한다() {
        //given
        List<Integer> wrongList = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 2;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.setWinningNumber(wrongList, bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 당첨번호는 1 이상 45 이하여야 한다.")
    @Test
    void 로또_당첨_번호는_1이상_45이하여야_한다() {
        //given
        List<Integer> wrongList = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 7;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.setWinningNumber(wrongList, bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 보너스번호는 1 이상 45 이하여야 한다.")
    @Test
    void 로또_보너스_번호는_1이상_45이하여야_한다() {
        //given
        List<Integer> wrongList = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 47;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.setWinningNumber(wrongList, bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 당첨번호는 6개를 초과하여 존재하면 안된다.")
    @Test
    void 로또_당첨_번호는_6개를_초과하면_안된다() {
        //given
        List<Integer> wrongList = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.setWinningNumber(wrongList, bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 당첨번호는 6개 미만으로 존재하면 안된다.")
    @Test
    void 로또_당첨_번호는_6개_미만으로_존재하면_안된다() {
        //given
        List<Integer> wrongList = List.of(1, 2, 3, 4, 5);
        int bonusNumber = 8;
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.setWinningNumber(wrongList, bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @Test
    void 당첨_수익률_계산() {
        //given
        Map<Prize, Integer> winResult = new HashMap<>();
        winResult.put(Prize.FIFTH_PLACE, 1);
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();
        int cost = 8000;
        double expectedResult = 62.5;
        lotteryRoundManager.purchaseLotto(cost);

        //when
        double actual = lotteryRoundManager.calculateBenefit(winResult);

        //then
        assertThat(actual).isEqualTo(expectedResult);
    }
}
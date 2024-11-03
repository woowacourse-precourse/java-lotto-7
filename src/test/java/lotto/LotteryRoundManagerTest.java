package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryRoundManagerTest {
    private final String ERROR_MESSAGE = "[ERROR] ";
    @DisplayName("로또의 구입은 1000원 단위로 이루어져야 한다.")
    @Test
    void 로또_구입_성공(){
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
    void 로또_구입_1000원단위_X(){
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
    void 로또_구입_지나친_가격(int cost){
        //given
        LotteryRoundManager lotteryRoundManager = new LotteryRoundManager();

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryRoundManager.purchaseLotto(cost))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}
package lotto.shop.bandingmachine;

import lotto.MessageCenter;
import lotto.shop.Pos;
import lotto.user.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TouchScreenTest {

    TouchScreen touchScreen = new TouchScreen();

    @BeforeEach
    void setUp() {
        TrialHistory trialHistory = new TrialHistory();
        DrawnNumbers drawnNumbers = DrawnNumbers.create();
        DrawSystem drawSystem = new DrawSystem(drawnNumbers);
        Pos pos = new Pos();
        Printer printer = new Printer();
        UserStorage.clean();
        touchScreen.trialHistory.savePayment(100000);
    }

    @Test
    @DisplayName("자동발권 전 구매시도 기록을 불러오려고 하면 예외가 발생한다")
    void 자동발권_전_구매시도_기록을_불러오려고_하면_예외가_발생한다() {
        assertThatThrownBy(() -> touchScreen.trialHistory.getDrawnNumberPacks())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_SAVE.get());
    }

    @Test
    @DisplayName("자동발권 전 유저 구매기록을 불러오려고 하면 예외가 발생한다")
    void 자동발권_전_유저_구매기록을_불러오려고_하면_예외가_발생한다() {
        assertThatThrownBy(() -> UserStorage.get())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_USERSTORAGE.get());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, Integer.MIN_VALUE})
    @DisplayName("자동발권 시 구매장수가 양의 정수가 아니면 예외가 발생한다.")
    void 자동발권_시_구매장수가_양의_정수가_아니면_예외가_발생한다(Integer totalCount) {
        assertThatThrownBy(() -> touchScreen.pushDraw(totalCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_COUNT.get());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, Integer.MIN_VALUE})
    @DisplayName("자동발권 시 저장된 결제 금액이 NULL이거나 0 또는 마이너스면 예외가 발생한다.")
    void 자동발권_시_저장된_결제_금액이_NULL이거나_0_또는_마이너스면_예외가_발생한다(Integer payment) {
        touchScreen.trialHistory.savePayment(payment);
        assertThatThrownBy(() -> touchScreen.pushDraw(8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PAYMENT.get());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,100})
    @DisplayName("자동발권 후 구매시도 기록에 기록된 번호묶음의 사이즈는 구매장수와 같다.")
    void 자동발권_후_구매시도_기록에_기록된_번호묶음의_사이즈는_구매장수와_같다(Integer totalCount) {
        touchScreen.pushDraw(totalCount);
        assertThat(touchScreen.getTrialHistory().getDrawnNumberPacks().size())
                .isEqualTo(totalCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,100})
    @DisplayName("자동발권 후 유저 구매기록에 기록된 구매내역의 사이즈는 구매장수와 같다")
    void 자동발권_후_유저_구매기록에_기록된_구매내역의_사이즈는_구매장수와_같다(Integer totalCount) {
        touchScreen.pushDraw(totalCount);
        assertThat(UserStorage.get().size()).isEqualTo(totalCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,100})
    @DisplayName("자동발권 후 구매시도 내역과 유저 구매기록의 개수는 같다.")
    void 자동발권_후_구매시도_내역과_유저_구매기록의_개수는_같다(Integer totalCount) {
        touchScreen.pushDraw(totalCount);
        assertThat(UserStorage.get().size())
                .isEqualTo(touchScreen.getTrialHistory().getDrawnNumberPacks().size());
    }
}

package lotto.shop.bandingmachine;

import java.util.ArrayList;
import java.util.List;
import lotto.MessageCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialHistoryTest {

    TrialHistory trialHistory = new TrialHistory();

    @BeforeEach
    void setUp() {
        trialHistory.clean();
    }

    @Test
    @DisplayName("기결제내역이 존재하면 결제내역 시도 시에 예외가 발생한다.")
    void 기결제내역이_존재하면_결제내역_저장_시에_예외가_발생한다(){
        trialHistory.savePayment(100000);
        assertThatThrownBy(() -> trialHistory.savePayment(8000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PAID.get());
    }

    @Test
    @DisplayName("기존 구매장수 저장 내역이 존재하면 구매장수 저장 시에 예외가 발생한다.")
    void 기존_구매장수_저장_내역이_존재하면_구매장수_저장_시에_예외가_발생한다(){
        trialHistory.saveTotalCount(10);
        assertThatThrownBy(() -> trialHistory.saveTotalCount(8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PAID.get());
    }

    @Test
    @DisplayName("기존 번호묶음 저장 내역이 존재하면 번호묶음 저장 시에 예외가 발생한다.")
    void 기존_번호묶음_저장_내역이_존재하면_번호묶음_저장_시에_예외가_발생한다(){
        List<DrawnNumbers> drawnNumberPacks = new ArrayList<>();
        trialHistory.saveDrawnNumberPacks(drawnNumberPacks);
        assertThatThrownBy(() -> trialHistory.saveDrawnNumberPacks(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_DRAWN.get());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -1000, 1, 800, 1111, 8888, Integer.MIN_VALUE, Integer.MAX_VALUE})
    @DisplayName("금액이 1000의 배수인 양의 정수가 아니면 금액 저장 시에 예외가 발생한다.")
    void 금액이_1000의_배수인_양의_정수가_아니면_금액_저장_시에_예외가_발생한다(Integer payment){
        assertThatThrownBy(() -> trialHistory.savePayment(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PAID.get());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -8888, -1000, Integer.MIN_VALUE})
    @DisplayName("구매장수가 양의 정수가 아니면 구매장수 저장 시에 예외가 발생한다.")
    void 구매장수가_양의_정수가_아니면_구매장수_저장_시에_예외가_발생한다(Integer count){
        assertThatThrownBy(() -> trialHistory.saveTotalCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PAID.get());
    }

    @Test
    @DisplayName("구매금액이 저장되어 있지 않으면 구매금액 호출 시에 예외가 발생한다.")
    void 구매금액이_저장되어_있지_않으면_구매금액_호출_시에_예외가_발생한다(){
        assertThatThrownBy(() -> trialHistory.getPayment())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PAYMENT.get());
    }

    @Test
    @DisplayName("구매장수가 저장되어 있지 않으면 구매장수 호출 시에 예외가 발생한다.")
    void 구매장수가_저장되어_있지_않으면_구매장수_호출_시에_예외가_발생한다(){
        assertThatThrownBy(() -> trialHistory.getTotalCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_COUNT.get());
    }

    @Test
    @DisplayName("번호묶음이 저장되어 있지 않으면 번호묶음 호출 시에 예외가 발생한다.")
    void 번호묶음이_저장되어_있지_않으면_번호묶음_호출_시에_예외가_발생한다(){
        assertThatThrownBy(() -> trialHistory.getDrawnNumberPacks())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_SAVE.get());
    }

}

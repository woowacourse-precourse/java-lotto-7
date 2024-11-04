package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPurchaseTest {
    private final LottoGenerator generator = new DummyLottoGenerator(); // 더미 로또 생성기 사용
    private final LottoPurchase lottoPurchase = new LottoPurchase(generator);

    @DisplayName("구입 금액이 1000원 단위일 때 로또를 정상적으로 구매한다.")
    @Test
    void 금액이_1000원단위일_때_로또를_구매한다() {
        List<Lotto> lottos = lottoPurchase.purchase(3000);

        assertThat(lottos).hasSize(3); // 3000원으로 3개의 로또를 구매해야 함
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void 금액이_1000원단위가_아닐_때_예외가_발생한다() {
        assertThatThrownBy(() -> lottoPurchase.purchase(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 1000원단위로 떨어져야합니다."); // 예외 메시지 검증
    }

    // 더미 로또 생성기 클래스
    static class DummyLottoGenerator implements LottoGenerator {
        @Override
        public Lotto generate() {
            return new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 간단한 고정값 리턴
        }
    }
}

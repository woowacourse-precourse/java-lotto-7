package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.view.ErrorConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("구입 금액에 따라 로또 티켓 개수를 정확히 생성한다.")
    @Test
    void 로또_티켓_개수_계산() {
        // Given
        LottoGenerator generator = new DefaultLottoGenerator();
        int purchaseAmount = 5000;

        // When
        List<Lotto> lottos = generator.generateLottos(purchaseAmount);

        // Then
        assertThat(lottos).hasSize(5);
    }

    @DisplayName("생성된 각 로또 티켓은 6개의 숫자를 가지고 중복되지 않는다.")
    @Test
    void 로또_티켓_번호_중복_확인() {
        // Given
        DefaultLottoGenerator generator = new DefaultLottoGenerator();

        // When
        Lotto lotto = generator.generateLotto();

        // Then
        assertThat(lotto).isNotNull(); // 생성된 lotto 객체가 유효한지 검증
        assertThat(lotto.getNumbers()).hasSize(6); // 숫자 개수 확인
        assertThat(lotto.getNumbers().stream().distinct().count()).isEqualTo(6); // 중복 확인
    }

    @DisplayName("로또 번호 생성 중 예외 발생 시 예외 메시지 출력")
    @Test
    void 로또번호_생성_예외발생시_예외메시지_출력() {
        // Given
        LottoGenerator generator = new DefaultLottoGenerator() {
            @Override
            protected Lotto generateLotto() {
                throw new IllegalArgumentException("[ERROR] 임의로 예외 발생");
            }
        };
        int purchaseAmount = 5000;

        // When & Then
        assertThatThrownBy(() -> generator.generateLottos(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.LOTTO_NUMBER_GENERATION_FAILED);
    }
}

package lotto.domain.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("[Domain] Lottos")
public class LottosTest {

    private static class TestLottoFactory implements LottoFactory {
        @Override
        public Lotto createLotto() {
            return new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 예시로 고정된 번호를 가진 로또 생성
        }
    }

    @Nested
    @DisplayName("[createLottos] 로또 목록 생성 기능을 검증한다")
    class CreateLottosTest {

        @Test
        @DisplayName("[create] 유효한 로또 수를 입력하면 입력값에 의해 로또 목록이 정상적으로 생성된다. ")
        public void Given_ValidPurchasedLottoCount_When_CreateLottos_Then_ReturnLottos() {
            // Given
            int purchasedLottoCount = 3;
            LottoFactory lottoFactory = new TestLottoFactory();

            // When
            Lottos lottos = Lottos.createLottos(purchasedLottoCount, lottoFactory);

            // Then
            assertNotNull(lottos);
            assertEquals(purchasedLottoCount, lottos.getLottos().size());

            for (Lotto lotto : lottos.getLottos()) {
                assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
            }
        }

        @Test
        @DisplayName("[create] 로또 수가 0일 경우 빈 로또 목록이 반환된다")
        public void Given_ZeroPurchasedLottoCount_When_CreateLottos_Then_ReturnEmptyLottos() {
            // Given
            int purchasedLottoCount = 0;
            LottoFactory lottoFactory = new TestLottoFactory();

            // When
            Lottos lottos = Lottos.createLottos(purchasedLottoCount, lottoFactory);

            // Then
            assertNotNull(lottos);
            assertEquals(0, lottos.getLottos().size());
        }
    }


    @Nested
    @DisplayName("[getLottos] 로또들이 정상적으로 반환되는 지 확인한다")
    class GetLottosTest{

        @Test
        @DisplayName("[return] 정상적으로 로또들을 반환한다")
        public void Given_ValidNumbers_When_GetNumbers_Then_ReturnNumbers() {
            // Given
            int purchasedLottoCount = 3;
            LottoFactory lottoFactory = new TestLottoFactory();
            Lottos lottos = Lottos.createLottos(purchasedLottoCount, lottoFactory);

            // When
            List<Lotto> returnedLottos = lottos.getLottos();

            // Then
            assertNotNull(returnedLottos);
            assertEquals(purchasedLottoCount, returnedLottos.size());

            for (Lotto lotto : returnedLottos) {
                assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
            }

        }

    }
}

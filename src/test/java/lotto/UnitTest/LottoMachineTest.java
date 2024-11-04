package lotto.UnitTest;

import lotto.Model.Lotto;
import lotto.Model.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoMachineTest {

    @Test
    @DisplayName("로또 구입 금액에 따른 로또 개수 발급 테스트")
    void testGenerateLottosCount() {
        int purchaseAmount = 8000; // 8장 발급
        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);
        assertThat(lottos).hasSize(8);
    }

    @Test
    @DisplayName("각 로또 번호가 1부터 45 사이의 중복 없는 6개 숫자로 구성되어야 함")
    void testLottoNumberRangeAndUniqueness() {
        int purchaseAmount = 1000; // 1장 발급
        List<Lotto> lottos = LottoMachine.generateLottos(purchaseAmount);

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6);
            assertThat(numbers).doesNotHaveDuplicates();
            assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
        }
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 IllegalArgumentException 발생")
    void testInvalidPurchaseAmount() {
        int invalidAmount = 1500; // 1,000원 단위가 아님
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoMachine.generateLottos(invalidAmount);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }
}

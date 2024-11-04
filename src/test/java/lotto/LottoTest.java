package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "15000:15", "9223372036854770000:9223372036854770"}, delimiter = ':')
    void 구매한_로또_수량_반환_테스트(String purchaseAmount, long lottoCount) {
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);

        assertEquals(lottoPurchase.getPurchasedLottoCount(), lottoCount);
    }

    @Test
    void 발행한_로또_번호_오름차순_정렬_테스트() {
        Lotto lotto = new Lotto(List.of(30, 20, 21, 2, 45, 44));

        assertThat(lotto.getNumbers()).isEqualTo(List.of(2, 20, 21, 30, 44, 45));
    }

    @DisplayName("로또 번호는 중복이 아닌 1에서 45까지의 숫자 6개가 생성되어야한다.")
    @Test
    void 로또_번호_생성_테스트() {
        LottoGenerator lottoGenerator = new LottoGenerator(5);

        List<Lotto> tickets = lottoGenerator.getTickets();

        for (Lotto lotto : tickets) {
            List<Integer> numbers = lotto.getNumbers();

            assertThat(numbers).hasSize(6);
            assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
            assertThat(new HashSet<>(numbers)).hasSize(6);
        }
    }

    @Test
    void 로또_당첨_확인_테스트() {
        List<Lotto> tickets = new ArrayList<>();
        tickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));   // 1등
        tickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));   // 2등

        LottoWinningChecker checker = new LottoWinningChecker(tickets, List.of(1, 2, 3, 4, 5, 6), 7);
        List<Integer> expectedPlaceCount = List.of(1, 1, 0, 0, 0);  // 1등 1개, 2등 1개, 나머지 0개

        assertThat(checker.getPlaceCount()).isEqualTo(expectedPlaceCount);
    }

    @DisplayName("수익률은 소수점 둘째 자리에서 반올림한다.")
    @Test
    void 수익률_테스트() {
        EarningsRateCalculator earningsRateCalculator = new EarningsRateCalculator(List.of(0, 0, 0, 1, 1), 3000);

        assertThat(earningsRateCalculator.getEarningsRate()).isEqualTo(1833.3);
    }
}
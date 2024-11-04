package lotto;

import lotto.enums.LottoResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("로또 구매 금액이 유효하지 않은 케이스")
    @Test
    void 로또_구매_금액이_유효하지_않은_케이스() {
        assertThatThrownBy(() -> lottoMachine.purchaseLotto(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.purchaseLotto(500))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.purchaseLotto(1001))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.purchaseLotto(10500))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.purchaseLotto(-300))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.purchaseLotto(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 로또를 구매하는 케이스")
    @Test
    void 정상_로또_구매_케이스() {
        List<Lotto> lottos1 = lottoMachine.purchaseLotto(1000);
        List<Lotto> lottos2 = lottoMachine.purchaseLotto(5000);
        List<Lotto> lottos3 = lottoMachine.purchaseLotto(10000);

        // 로또 개수 확인
        assertThat(lottos1.size()).isEqualTo(1);
        assertThat(lottos2.size()).isEqualTo(5);
        assertThat(lottos3.size()).isEqualTo(10);

        // 로또 번호 중복 확인
        for (Lotto lotto : lottos1) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
            HashSet<Integer> uniqueLottoNumbers = new HashSet<>(lotto.getNumbers());
            assertThat(lotto.getNumbers().size()).isEqualTo(uniqueLottoNumbers.size());
        }

        for (Lotto lotto : lottos2) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
            HashSet<Integer> uniqueLottoNumbers = new HashSet<>(lotto.getNumbers());
            assertThat(lotto.getNumbers().size()).isEqualTo(uniqueLottoNumbers.size());
        }

        for (Lotto lotto : lottos3) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
            HashSet<Integer> uniqueLottoNumbers = new HashSet<>(lotto.getNumbers());
            assertThat(lotto.getNumbers().size()).isEqualTo(uniqueLottoNumbers.size());
        }

        // 로또 번호 오름차순 확인
        for (Lotto lotto : lottos1) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> sortedLottoNumbers = lottoNumbers.stream()
                    .sorted()
                    .toList();
            assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
        }

        for (Lotto lotto : lottos2) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> sortedLottoNumbers = lottoNumbers.stream()
                    .sorted()
                    .toList();
            assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
        }

        for (Lotto lotto : lottos3) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> sortedLottoNumbers = lottoNumbers.stream()
                    .sorted()
                    .toList();
            assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
        }
    }

    @DisplayName("로또 결과 확인 케이스")
    @Test
    void 로또_결과_확인_케이스() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 10, 20, 30)); // 5등
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 20)); // 4등
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 20)); // 3등
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 9, 10, 20, 30)); // 꽝
        Lotto lotto7 = new Lotto(Arrays.asList(1, 9, 10, 20, 30, 40)); // 꽝
        Lotto lotto8 = new Lotto(Arrays.asList(9, 10, 20, 30, 40, 7)); // 꽝 + 보너스번호
        Lotto lotto9 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)); // 5등 + 보너스번호
        Lotto lotto10 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)); // 4등 + 보너스번호

        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8, lotto9, lotto10);

        List<LottoResultType> results = lottoMachine.checkLottoResult(lottos, winningNumbers, bonusNumber);

        assertThat(results.get(0)).isEqualTo(LottoResultType.FIFTH_PLACE);
        assertThat(results.get(1)).isEqualTo(LottoResultType.FOURTH_PLACE);
        assertThat(results.get(2)).isEqualTo(LottoResultType.THIRD_PLACE);
        assertThat(results.get(3)).isEqualTo(LottoResultType.SECOND_PLACE);
        assertThat(results.get(4)).isEqualTo(LottoResultType.FIRST_PLACE);
        assertThat(results.get(5)).isEqualTo(LottoResultType.NO_PRIZE);
        assertThat(results.get(6)).isEqualTo(LottoResultType.NO_PRIZE);
        assertThat(results.get(7)).isEqualTo(LottoResultType.NO_PRIZE);
        assertThat(results.get(8)).isEqualTo(LottoResultType.FIFTH_PLACE);
        assertThat(results.get(9)).isEqualTo(LottoResultType.FOURTH_PLACE);

    }
}
package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("구입 금액이 0보다 작거나 같으면 예외가 발생한다.")
    @Test
    void generateLottoList_구입금액이_0보다_작거나_같으면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoGenerator.generateLottoList(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
        assertThatThrownBy(() -> lottoGenerator.generateLottoList(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    @DisplayName("구입 금액에 따라 올바른 수의 로또를 생성한다.")
    @Test
    void generateLottoList_구입금액에_따라_올바른_수의_로또를_생성한다() {
        List<Lotto> lottoList = lottoGenerator.generateLottoList(5000);
        assertThat(lottoList).hasSize(5);

        lottoList.forEach(lotto -> {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
        });
    }

    @DisplayName("총 판매 금액을 올바르게 계산한다.")
    @Test
    void getTotalSales_구입금액에_따라_올바른_판매금액을_계산한다() {
        int totalSales = lottoGenerator.getTotalSales(5000);
        assertThat(totalSales).isEqualTo(5000);

        totalSales = lottoGenerator.getTotalSales(10000);
        assertThat(totalSales).isEqualTo(10000);
    }

    @DisplayName("총 판매 금액이 0보다 크면 올바른 값이 반환된다.")
    @Test
    void getTotalSales_구입금액이_0보다_크면_올바른_값이_반환된다() {
        int totalSales = lottoGenerator.getTotalSales(0);
        assertThat(totalSales).isEqualTo(0);
    }
}

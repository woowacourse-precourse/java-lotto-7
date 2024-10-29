package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.PurchaseLotto;
import lotto.domain.dto.LottoDto;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("구매한 로또 게임 장수를 확인한다.")
    @Test
    void 로또_구매_장수_테스트() {
        PurchaseLotto purchaseLotto = new PurchaseLotto(8000);

        assertThat(purchaseLotto.calculateLottoGameCount()).isEqualTo(8);
    }

    @DisplayName("구매할 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 로또_구매_금액_1000원_미만_예외_테스트() {
        assertThatThrownBy(() -> new PurchaseLotto(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매할 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_구매_금액_1000원_단위가_아닐때_예외_테스트() {
        assertThatThrownBy(() -> new PurchaseLotto(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 발행하고 1~45 사이의 중복없는 6개의 숫자로 발행되는지 확인한다.")
    @Test
    void 로또_발행_테스트() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();

        Lotto lotto = new Lotto(numberGenerator.generate());
        LottoDto lottoDto = lotto.toDto();

        assertThat(lottoDto.getNumbers()).hasSize(6);
        assertThat(lottoDto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        assertThat(lottoDto.getNumbers()).doesNotHaveDuplicates();
    }

    @DisplayName("로또를 여러 개 발행하고 1~45 사이의 중복없는 6개의 숫자로 발행되는지 확인한다.")
    @Test
    void 로또_여러개_발행_테스트() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        int numberOfLottos = 5;

        List<LottoDto> lottoDtos = IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(numberGenerator.generate()).toDto())
                .toList();

        lottoDtos.forEach(lottoDto -> {
            assertThat(lottoDto.getNumbers()).hasSize(6);
            assertThat(lottoDto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
            assertThat(lottoDto.getNumbers()).doesNotHaveDuplicates();
        });
    }
}

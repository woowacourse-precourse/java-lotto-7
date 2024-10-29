package lotto;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.PurchaseLotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottoDto;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void 당첨번호_보너스번호_중복_예외_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        Lotto lotto = new Lotto(winningNumbers);

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행한 로또의 당첨 내역을 확인한다.")
    @ParameterizedTest
    @MethodSource("createLottoAndExpectedRank")
    void 로또_당첨_내역_확인_테스트(List<Integer> lottoNumbers, Rank expectedRank) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        
        Lotto lotto = new Lotto(lottoNumbers);
        Rank result = winningLotto.getLottoRank(lotto);

        assertThat(result).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> createLottoAndExpectedRank() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 9, 10), Rank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 11, 12, 13), Rank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 14, 15, 16, 17), Rank.NONE)
        );
    }
}

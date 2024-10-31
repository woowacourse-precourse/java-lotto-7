package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoShop;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottoDto;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        LottoShop lottoShop = new LottoShop(8000);

        assertThat(lottoShop.calculateLottoGameCount()).isEqualTo(8);
    }

    @DisplayName("구매할 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 로또_구매_금액_1000원_미만_예외_테스트() {
        assertThatThrownBy(() -> new LottoShop(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매할 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_구매_금액_1000원_단위가_아닐때_예외_테스트() {
        assertThatThrownBy(() -> new LottoShop(1100))
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

    static Stream<Arguments> createLottoAndExpectedRank() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 9, 10), Rank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 11, 12, 13), Rank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 14, 15, 16, 17), Rank.NONE)
        );
    }

    @DisplayName("로또 당첨금 합계와 구매한 금액에 대해 수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource("createLottoListAndExpectedEarningRate")
    void 로또_수익률_계산_테스트(List<Lotto> issuedLottos, double expectedEarningRate) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        int money = 5000;

        LottoGameResult lottoGameResult = new LottoGameResult();
        issuedLottos.stream()
                .map(winningLotto::getLottoRank)
                .forEach(lottoGameResult::updateResult);

        double earningRate = lottoGameResult.calculateEarningRate(money);

        assertThat(earningRate).isEqualTo(expectedEarningRate);
    }

    static Stream<Arguments> createLottoListAndExpectedEarningRate() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)), //1등
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)), //2등
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)), //3등
                                new Lotto(List.of(1, 2, 3, 4, 8, 9)), //4등
                                new Lotto(List.of(10, 11, 12, 13, 14, 15)) //당첨 없음
                        ), 40631000 //수익률, (2,000,000,000 + 50,000,000 + 1,500,000 + 50,000) / 5000 * 100
                )
        );
    }

}

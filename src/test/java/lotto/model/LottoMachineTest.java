package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("구입한 금액만큼 로또를 구매할 수 있다.")
    @ParameterizedTest
    @MethodSource("generatePriceAndCountList")
    void 구입한_금액만큼_로또를_구매할_수_있다(int price, int count) {
        // when
        List<Lotto> lottoList = lottoMachine.buyLottoByPrice(price);

        // then
        Assertions.assertThat(lottoList.size()).isEqualTo(count);
    }

    @DisplayName("구입할 금액이 로또금액 단위가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1234", "900", "-1", "0"})
    void 구입할_금액이_로또금액_단위가_아닐_경우_에러가_발생한다(int price) {
        Assertions.assertThatThrownBy(() -> {
            lottoMachine.buyLottoByPrice(price);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호로 당첨 로또를 생성할 수 있다.")
    @Test
    void 당첨_번호와_보너스_번호로_당첨_로또를_생성할_수_있다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = lottoMachine.generateWinningLotto(lotto, bonusNumber);

        // then
        Assertions.assertThat(winningLotto.getWinningNumberList()).isEqualTo(lotto.getNumbers());
        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateDuplicatedWinningAndBonusNumber")
    void 당첨_번호와_보너스_번호가_중복되면_에러가_발생한다(Lotto lotto, int bonusNumber) {
        Assertions.assertThatThrownBy(() -> {
            lottoMachine.generateWinningLotto(lotto, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generatePriceAndCountList() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(3000, 3),
                Arguments.of(226000, 226)
        );
    }

    private static Stream<Arguments> generateDuplicatedWinningAndBonusNumber() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 3),
                Arguments.of(new Lotto(List.of(3, 5, 11, 22, 31, 44)), 22),
                Arguments.of(new Lotto(List.of(1, 6, 28, 31, 35, 36)), 31),
                Arguments.of(new Lotto(List.of(16, 18, 33, 34, 44, 45)), 44)
        );
    }
}
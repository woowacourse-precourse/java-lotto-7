package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.domain.LottoResult.FIFTH;
import static lotto.domain.LottoResult.FOURTH;
import static lotto.domain.LottoResult.NONE;
import static lotto.domain.LottoResult.SECOND;
import static lotto.domain.LottoResult.THIRD;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_COUNTS;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_DUPLICATE;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_RANGE;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "3000,3", "7000,7"}, delimiter = ',')
    @DisplayName("buyLotto - 1000원 단위 돈이 입력되면 정상적으로 로또를 구매한다.")
    void successBuyLotto(int money, int expectedCount) {
        // when
        Lottos lottos = lottoService.buyLotto(money);
        // then
        assertThat(lottos.getLottos().size()).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("buyLotto - 1000원 단위 돈이 들어오지 않으면 예외가 발생한다.")
    void failBuyLottoWithInvalidUnit() {
        // given
        int money = 6666;
        // when & then
        assertThatThrownBy(() -> lottoService.buyLotto(money))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -10000, 0})
    @DisplayName("buyLotto - 1개 이상 사지 않은 경우 예외가 발생한다.")
    void failBuyLottoWIthInvalidCount(int money) {
        // when & then
        assertThatThrownBy(() -> lottoService.buyLotto(money))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_PURCHASE_MIN.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("createLottoMachine - 보너스 번호와 당첨 번호들을 겹치면 예외가 발생된다.")
    void failCreateLottoMachineWithDuplicate(int bonus) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(bonus);
        // when & then
        assertThatThrownBy(() -> lottoService.createLottoMachine(lotto, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("createLottoMachine - 보너스 번호와 당첨 번호가 겹치지 않은 경우 정상적으로 LottoMachine을 생성한다.")
    void successCreateLottoMachine() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(7);
        // when & then
        assertDoesNotThrow(() -> lottoService.createLottoMachine(lotto, bonusNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 46, 100})
    @DisplayName("createBonusNumber - 보너스 번호의 범위를 넘어가는 경우 예외가 발생한다.")
    void failCreateBonusNumberWithInvalidRange(int bonus) {
        assertThatThrownBy(() -> lottoService.createBonusNumber(bonus))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20, 30, 40, 45})
    @DisplayName("createBonusNumber - 보너스 번호 범위를 넘어가지 않으면 정상적으로 생성된다.")
    void successCreateBonusNumber(int bonus) {
        assertDoesNotThrow(() -> lottoService.createBonusNumber(bonus));
    }

    @Test
    @DisplayName("createWinnerLotto - 중복되는 번호가 있는 경우 예외가 발생한다.")
    void failCreateWinnerLottoWithDuplicate() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 3, 4, 5);
        // when & then
        assertThatThrownBy(() -> lottoService.createWinnerLotto(numbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_LOTTO_DUPLICATE.getMessage());
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("createWinnerLotto - 로또 번호가 6개가 아닌 경우 예외가 발생한다.")
    void failCreateWinnerLottoWithInvalidCount(List<Integer> numbers) {
        assertThatThrownBy(() -> lottoService.createWinnerLotto(numbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_LOTTO_COUNTS.getMessage());
    }

    static Stream<List<Integer>> failCreateWinnerLottoWithInvalidCount() {
        return Stream.of(
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 3),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5, 6, 7, 8)
        );
    }

    @Test
    @DisplayName("createWinnerLotto - 로또 범위 밖에 숫자가 존재하면 예외가 발생한다.")
    void failCreateWinnerLottoWithInvalidRange() {
        // given
        List<Integer> numbers = List.of(1, 47, 2, 3, 4, 5);
        // when & then
        assertThatThrownBy(() -> lottoService.createWinnerLotto(numbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("createWinnerLotto - 정상적인 번호면 Lotto를 정상적으로 생성한다.")
    void successCreateWinnerLotto() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        // when
        Lotto winnerLotto = lottoService.createWinnerLotto(numbers);
        assertThat(winnerLotto.getSortedNumbers().size()).isEqualTo(6);
        assertThat(winnerLotto.getSortedNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("getLottoResult - 구매한 로또와 당첨 로또 번호들을 비교하여 정상적으로 결과를 반환한다.")
    void successGetLottoResult() {
        // given
        LottoMachine lottoMachine = createLottoMachine();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    // given
                    Lottos lottos = Lottos.from(8);
                    // when
                    Map<LottoResult, Integer> lottoResult = lottoService.getLottoResult(lottoMachine, lottos);
                    // then
                    assertThat(lottoResult.size()).isEqualTo(4);
                    assertThat(lottoResult.getOrDefault(NONE, 0)).isEqualTo(0);
                    assertThat(lottoResult.get(FIFTH)).isEqualTo(2);
                    assertThat(lottoResult.get(FOURTH)).isEqualTo(3);
                    assertThat(lottoResult.get(THIRD)).isEqualTo(2);
                    assertThat(lottoResult.get(SECOND)).isEqualTo(1);
                },
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 6, 8, 9, 10),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 4, 6, 8, 9),
                List.of(2, 4, 5, 6, 7, 43),
                List.of(2, 4, 5, 6, 1, 45),
                List.of(2, 3, 4, 5, 6, 45),
                List.of(2, 3, 4, 6, 5, 7)
                // 5등 2개, 4등 3개, 3등 2개, 2등 1개
        );
    }

    private LottoMachine createLottoMachine() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(7);
        return LottoMachine.of(lotto, bonusNumber);
    }
}
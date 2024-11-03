package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constants.PrizeRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("로또 번호 범위가 1~45을 벗어나면 예외가 발생한다.")
    @CsvSource({
            "0,1,2,3,4,5",
            "1,2,3,4,5,46"
    })
    void throwExceptionIfLottoNumberIsNotInRange(String numberString) {
        assertThatThrownBy(() -> new Lotto(Stream.of(numberString.split(","))
                .map(Integer::parseInt).toList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 변경하려 하면 예외 발생")
    @Test
    void throwExceptionIfModifyNumbersInLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> numbersFromLotto = lotto.getNumbers();

        assertThatThrownBy(() -> numbersFromLotto.set(0, 7)).isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 티켓의 번호들과, 당첨 로또의 번호들 비교해 겹치는 숫자의 갯수와 보너스 번호 포함여부를 반환")
    @CsvSource({
            "'1,2,3,4,5,6', '1,2,3,7,8,9', '10', 'MATCH_THREE'",
            "'1,2,3,4,5,6', '1,2,3,4,5,7', '12', 'MATCH_FIVE'",
            "'1,2,3,4,5,6', '1,2,3,4,5,7', '6', 'MATCH_FIVE_WITH_BONUS'",
            "'1,2,3,4,5,6', '40,41,42,43,44,45', '12', 'MATCH_FAIL'"
    })
    void getPrizeRankTest(String ticketNumbers, String winningNumbers, String bonusNumberString,
                          String prizeRankString) {
        Lotto ticketLotto = new Lotto(Arrays.stream(ticketNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        Lotto lotto = new Lotto(Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        int bonusNumber = Integer.parseInt(bonusNumberString);

        PrizeRank prizeRank = PrizeRank.valueOf(prizeRankString);

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        Assertions.assertThat(ticketLotto.getPrizeRank(winningLotto)).isEqualTo(prizeRank);
    }
}

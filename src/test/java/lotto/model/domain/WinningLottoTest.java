package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호와 당첨 번호가 중복이 아니면 정상 생성한다.")
    void testNoDuplicateCreateWinningLotto() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("10");

        assertThatCode(() -> new WinningLotto(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외를 던진다.")
    void testDuplicateWinningLottoThrowsException() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("1");

        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 6, FIRST",
            "1, 2, 3, 4, 5, 7, SECOND",
            "1, 2, 3, 4, 5, 16, THIRD",
            "1, 2, 3, 4, 15, 16, FOURTH",
            "1, 2, 3, 14, 15, 16, FIFTH",
            "1, 2, 13, 14, 15, 16, FAIL",
            "1, 12, 13, 14, 15, 16, FAIL",
            "11, 12, 13, 14, 15, 16, FAIL",
    })
    @DisplayName("로또의 매칭 개수와 보너스 적중 여부에 따라 등수를 반환한다.")
    void testReturnCorrectLottoRank(int i1, int i2, int i3, int i4, int i5, int i6, LottoRank lottoRank) {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(i1, i2, i3, i4, i5, i6));
        assertThat(winningLotto.determineRank(lotto)).isEqualTo(lottoRank);
    }
}


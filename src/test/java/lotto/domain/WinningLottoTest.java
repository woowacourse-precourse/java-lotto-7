package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    @DisplayName("WinningLotto 객체를 생성할 수 있다")
    void winningLotto_정상생성() {
        // Given
        List<LottoNumber> winningNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumber bonusNumber = new LottoNumber(7);

        // When
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // Then
        assertThat(winningLotto.match(new Lotto(winningNumbers))).isEqualTo(WinningRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 로또 번호에 포함될 경우 예외가 발생한다")
    void winningLotto_보너스번호_중복예외() {
        // Given
        List<LottoNumber> winningNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumber bonusNumber = new LottoNumber(1);

        // When , Then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoExceptionType.DUPLICATE_BONUS_NUMBER.errorMessage());
    }

    @Test
    @DisplayName("3등 당첨 결과를 정확히 판단하는지 확인한다")
    void winningLotto_당첨결과_판단() {
        // Given
        List<LottoNumber> winningNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // When
        Lotto userLotto = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(8)
        ));

        // Then
        assertThat(winningLotto.match(userLotto)).isEqualTo(WinningRank.THIRD_PLACE);
    }

    @Test
    @DisplayName("2등 당첨 결과를 정확히 판단하는지 확인한다")
    void winningLotto_2등_당첨결과_판단() {
        // Given
        List<LottoNumber> winningNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumber bonusNumber = new LottoNumber(8);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // When
        Lotto userLotto = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(8)
        ));

        // Then
        assertThat(winningLotto.match(userLotto)).isEqualTo(WinningRank.SECOND_PLACE);
    }

}
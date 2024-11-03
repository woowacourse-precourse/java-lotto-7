package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.db.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void numbersLengthOverException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicatedLottoNumException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 출력하면 오름차순으로 정렬되어 출력된다.")
    @Test
    void printLotto() {
        // given
        Lotto lotto = new Lotto(List.of(45, 6, 2, 4, 12, 5));
        // when
        String toString = lotto.toString();
        // then
        assertThat(toString).isEqualTo("[2, 4, 5, 6, 12, 45]");
    }

    @DisplayName("특정 숫자가 로또 번호에 포함되는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    void containsNum(int num, boolean expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when & then
        assertThat(lotto.contains(num)).isEqualTo(expected);
    }

    @DisplayName("로또 2개의 일치 개수를 반환한다.")
    @Test
    void matchCnt() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        // when & then
        assertThat(myLotto.getMatchCnt(winningLotto)).isEqualTo(3);
    }

    @DisplayName("로또 출력 형식 확인")
    @Test
    void stringFormat() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when & then
        assertThat(myLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}

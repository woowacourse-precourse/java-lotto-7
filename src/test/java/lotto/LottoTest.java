package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.domain.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호에 범위에 맞지않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위에_맞지않는_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 90)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("출력시 오름차순 정렬 확인")
    @Test
    void 출력시_오름차순_정렬() {
        List<Integer> numbers = List.of(3, 34, 12, 32, 24, 16);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.toString()).isEqualTo("[3, 12, 16, 24, 32, 34]");
    }

    @Test
    @DisplayName("6개 일치 - FIRST 랭크 반환")
    void 일등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6)).validateBonusNumber(7);
        assertEquals(LottoRank.FIRST, lotto.getRank(winning));
    }

    @Test
    @DisplayName("5개 일치 + 보너스 일치 - SECOND 랭크 반환")
    void 이등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6)).validateBonusNumber(7);
        assertEquals(LottoRank.SECOND, lotto.getRank(winning));
    }

    @Test
    @DisplayName("5개 일치 - THIRD 랭크 반환")
    void 삼등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6)).validateBonusNumber(7);
        assertEquals(LottoRank.THIRD, lotto.getRank(winning));
    }

    @Test
    @DisplayName("4개 일치 - FOURTH 랭크 반환")
    void 사등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6)).validateBonusNumber(7);
        assertEquals(LottoRank.FOURTH, lotto.getRank(winning));
    }

    @Test
    @DisplayName("3개 일치 - FIFTH 랭크 반환")
    void 오등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6)).validateBonusNumber(7);
        assertEquals(LottoRank.FIFTH, lotto.getRank(winning));
    }

    @Test
    @DisplayName("2개 이하 일치 - NONE 랭크 반환")
    void 꽝_당첨_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6)).validateBonusNumber(7);
        assertEquals(LottoRank.NONE, lotto.getRank(winning));

        Lotto lotto2 = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        assertEquals(LottoRank.NONE, lotto2.getRank(winning));
    }

}

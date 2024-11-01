package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @Test
    void 로또_번호_맞은_개수() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getCorrectCount(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        assertThat(lotto.getCorrectCount(new Lotto(List.of(1, 7, 8, 9, 10, 11)))).isEqualTo(1);
    }

    @Test
    void 보너스볼_매칭(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isBonusBallMatch(6)).isTrue();
        assertThat(lotto.isBonusBallMatch(7)).isFalse();
    }

    @Test
    void 로또_당첨개수_보너스볼_등수받기(){
        assertThat(LottoRank.findByCorrectCountAndBonusBall(1,TRUE)).isEqualTo(LottoRank.BLANK);
        assertThat(LottoRank.findByCorrectCountAndBonusBall(2,TRUE)).isEqualTo(LottoRank.BLANK);
        assertThat(LottoRank.findByCorrectCountAndBonusBall(5,TRUE)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findByCorrectCountAndBonusBall(6,FALSE)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 로또_조건_출력(){
        LottoRank lottoRank = LottoRank.SECOND;
        assertThat(LottoRank.getCondition(lottoRank)).isEqualTo("5개 일치, 보너스 볼 일치");
    }
}

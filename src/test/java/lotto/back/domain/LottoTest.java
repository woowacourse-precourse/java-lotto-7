package lotto.back.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.global.exception.InvalidLottoNumberRangeException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개의 중복되지 않은 [1,45] 사이의 번호를 가지는 로또 번호 생성")
    void 로또_객체_생성_테스트() {
        //given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        //when
        Lotto lotto = new Lotto(lottoNumbers);
        //then
        assertThat(lotto.getLottoNumbers()).containsAll(lottoNumbers);

    }

    @Test
    @DisplayName("6개의 숫자 중 범위를 벗어나는 로또 번호가 들어왔을 때 예외 발생")
    void 로또_생성_예외_테스트3() {
        //given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 46);
        //when
        //then
        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(InvalidLottoNumberRangeException.class);
    }

    @Test
    @DisplayName("getDrawCount 매서드, 추첨 번호에 대해 몇개가 동일한지 반환하는 테스트")
    void 추첨번호_일치_개수_테스트() {
        //given
        List<Integer> drawNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(1, 6, 3, 20, 25, 30);
        Lotto lotto = new Lotto(lottoNumbers);
        //when
        Integer drawCount = lotto.getDrawnNumberMatchCount(drawNumbers);
        //then
        assertThat(drawCount).isEqualTo(3);
    }

    @Test
    @DisplayName("getDrawCount 매서드, 추첨 번호에 대해 몇개가 동일한지 반환하는 테스트")
    void 보너스번호_일치_개수_테스트() {
        //given
        Integer bonusNumber = 5;
        List<Integer> lottoNumbers = List.of(1, 6, 3, 20, 25, 30);
        Lotto lotto = new Lotto(lottoNumbers);
        //when
        Integer drawCount = lotto.getBonusMatchCount(bonusNumber);
        //then
        assertThat(drawCount).isEqualTo(0);
    }
}


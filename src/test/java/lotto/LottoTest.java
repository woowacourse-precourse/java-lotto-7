package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개보다_부족하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열 입력 테스트")
    @Test
    void 빈_문자열_입력_테스트() {
        assertThatThrownBy(() -> runException("", "", ""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("입력된 돈이 1000원 단위가 아닐 때 예외가 발생한다")
    @Test
    void 입력된_돈이_1000원_단위가_아닐_때_예외가_발생한다() {
        assertThatThrownBy(() -> runException("1400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 개수가 6개 초과일 때 예외가 발생한다")
    @Test
    void 당첨_번호_개수가_6개_초과일_때_예외가_발생한다() {
        assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 개수가 6개 미만일 때 예외가 발생한다")
    @Test
    void 당첨_번호_개수가_6개_미만일_때_예외가_발생한다() {
        assertThatThrownBy(() -> runException("1000", "1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 구분자가 쉼표가 아닌 경우 예외가 발생한다")
    @Test
    void 당첨_번호_구분자가_쉼표가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> runException("1000", "1.2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 구분자 사이 띄어쓰기가 존재하는 경우 예외가 발생한다")
    @Test
    void 당첨_번호_구분자_사이_띄어쓰기가_존재하는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> runException("1000", "1.2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 숫자 범위가 유효하지 않은 경우 예외가 발생한다")
    @Test
    void 로또_번호_숫자_범위가_유효하지_않은_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 숫자 범위가 유효하지 않은 경우 예외가 발생한다")
    @Test
    void 당첨_번호_숫자_범위가_유효하지_않은_경우_예외가_발생한다() {
        assertThatThrownBy(() -> runException("1000", "0,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

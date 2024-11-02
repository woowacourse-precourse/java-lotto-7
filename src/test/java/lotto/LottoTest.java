package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void 로또_번호가_지정된_범위를_넘으면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액이_숫자가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> InputValidator.validateNumericNumber("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액이_천단위가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> InputValidator.validateThousandUnit(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값에_공백이_존재하면_예외가_발생한다(){
        assertThatThrownBy(() -> InputValidator.validateEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_숫자가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> LottoGame.parseWinningNumbers("a,b,c,d,e,f"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("dkjf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_지정된_범위를_넘으면_예외가_발생한다(){
        assertThatThrownBy(() -> InputValidator.validateBonusNumberRange(90))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

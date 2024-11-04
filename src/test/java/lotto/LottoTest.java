package lotto;

import lotto.exception.InputValidation;
import lotto.exception.ValidateValues;
import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 구입 금액이 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1000으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertThat(InputValidation.NOT_DIVISIBLE_BY_1000.validate("100")).isFalse();
    }

    @DisplayName("입력값(금액, 당첨번호, 보너스번호)이 빈 칸이면 예외가 발생한다.")
    @Test
    void 입력값이_빈_칸인지_확인한다() {
        assertThat(InputValidation.NOT_BLANK.validate("")).isFalse();
    }

    @DisplayName("입력값(금액, 당첨번호, 보너스번호)이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 입력값이_숫자인지_확인한다() {
        assertThat(InputValidation.NOT_NUMBER.validate("a")).isFalse();
    }

    @DisplayName("입력값(금액, 당첨번호, 보너스번호)이 정수가 아니면 예외가 발생한다.")
    @Test
    void 입력값이_정수가_아니면_예외가_발생한다() {
        assertThat(InputValidation.NOT_INTEGER.validate("1.1")).isFalse();
    }

    @DisplayName("입력값(당첨번호, 보너스번호)이 주어진 범위(1~45) 내에 존재하지 않으면 예외가 발생한다.")
    @Test
    void 입력값이_주어진_범위_내에_존재하지_않으면_예외가_발생한다() {
        assertThat(InputValidation.NOT_IN_RANGE_1_TO_45.validate("100")).isFalse();
    }

    @Test
    void 로또_객체_내_numbers_필드를_리턴한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 구입_금액을_검증하고_정수형으로_리턴한다() {
        int purchaseAmount = ValidateValues.purchaseAmount("1000");
        assertThat(purchaseAmount).isEqualTo(1000);
    }

    @Test
    void 당첨번호_또는_보너스번호를_검증하고_불린형으로_리턴한다() {
        boolean rangeCheck1 = ValidateValues.winningNumberOrBonusNumber("0");
        assertThat(rangeCheck1).isEqualTo(false);
        boolean rangeCheck2 = ValidateValues.winningNumberOrBonusNumber("1");
        assertThat(rangeCheck2).isEqualTo(true);

        boolean notNumberCheck1 = ValidateValues.winningNumberOrBonusNumber("a");
        assertThat(notNumberCheck1).isEqualTo(false);
        boolean notNumberCheck2 = ValidateValues.winningNumberOrBonusNumber("1");
        assertThat(notNumberCheck2).isEqualTo(true);

        boolean notIntegerCheck1 = ValidateValues.winningNumberOrBonusNumber("1.1");
        assertThat(notIntegerCheck1).isEqualTo(false);
        boolean notIntegerCheck2 = ValidateValues.winningNumberOrBonusNumber("1");
        assertThat(notIntegerCheck2).isEqualTo(true);
    }

    @Test
    void 구입금액만큼_로또를_발행하고_로또_객체_리스트를_리턴한다() {
        String purchaseAmount = "8000";
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.generateLotto(purchaseAmount).size()).isEqualTo(8);
    }

}

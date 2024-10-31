package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private final LottoNumberValidator lottoNumberValidator;

    public LottoNumberValidatorTest(){
        this.lottoNumberValidator = new LottoNumberValidator(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
    }

    @Test
    public void 로또_번호가_최대값을_초과한다면_예외가_발생한다(){
        int lottoNumber = 46;

        assertThatThrownBy(() -> lottoNumberValidator.validateLottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_번호가_최소값_미만이라면_예외가_발생한다(){
        int lottoNumber = 0;

        assertThatThrownBy(() -> lottoNumberValidator.validateLottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 올바른_로또_번호_테스트(){
        int lottoNumber = 1;

        lottoNumberValidator.validateLottoNumber(lottoNumber);
    }
}

package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class VerifierTest {

    @Test
    void 로또_구매_금액이_정수가_아니면_예외가_발생_한다() {
        assertThatThrownBy(() -> new Verifier().integerConversion("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구매_금액이_1000원_단위의_양수가_아니면_예외가_발생한다() {
        List<Integer> checkNumbers = Arrays.asList(-1,0,1001);
        for (Integer checkNumber : checkNumbers) {
            assertThatThrownBy(()-> new Verifier().lottoNumberRangeCheck(checkNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 로또_번호가_1에서_45사이의_값이_아니라면_예외가_발생_한다() {
        List<Integer> checkNumbers = Arrays.asList(-1,0,46);
        for (Integer checkNumber : checkNumbers) {
            assertThatThrownBy(()-> new Verifier().lottoNumberRangeCheck(checkNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 문자열에서_추출된_당첨번호가_정수가_아니라면_예외가_발생한다() {
        Verifier verifier = new Verifier();
        assertThatThrownBy(() -> verifier.validateLottoNumbers("a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열에서_추출된_당첨번호중에_범위를_넘어서는_값이_있다면_예외가_발생한다() {
        Verifier verifier = new Verifier();
        assertThatThrownBy(() -> verifier.validateLottoNumbers("-1,1,45"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> verifier.validateLottoNumbers("1,2,46"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> verifier.validateLottoNumbers("0,2,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열에서_추출된_당첨번호에_중복된_숫자가_있다면_예외가_발생한다() {
        Verifier verifier = new Verifier();
        assertThatThrownBy(() -> verifier.validateLottoNumbers("1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열에서_추출된_당첨번호가_총_6개가_아니라면_예외가_발생한다() {
        Verifier verifier = new Verifier();
        verifier.validateLottoNumbers("1,2,3,4,5");
        assertThatThrownBy(verifier::validateLottoSize)
                .isInstanceOf(IllegalArgumentException.class);
        verifier.validateLottoNumbers("1,2,3,4,5,6,7");
        assertThatThrownBy(verifier::validateLottoSize)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
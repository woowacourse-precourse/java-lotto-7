package lotto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    public void 정상_구매금액_1000의_배수() throws Exception{
        int priceInput = validator.validateAndGetUserPriceInput("8000");
        assertThat(priceInput).isEqualTo(8000);
    }

    @Test
    public void 정상_구매금액_0() throws Exception{
        int priceInput = validator.validateAndGetUserPriceInput("0");
        assertThat(priceInput).isEqualTo(0);
    }
    @Test
    public void 비정상_구매금액_1000의_배수가_아님() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetUserPriceInput("8001"));
    }
    @Test
    public void 비정상_구매금액_음수() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetUserPriceInput("-8001"));
    }
    @Test
    public void 비정상_구매금액_빈_문자열() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetUserPriceInput(""));
    }
    @Test
    public void 비정상_구매금액_공백_문자() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetUserPriceInput("  "));
    }
    @Test
    public void 비정상_구매금액_숫자_이외의_단어() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetUserPriceInput("454d"));
    }
    
    @Test
    public void 정상_로또번호() throws Exception{
        List<Integer> integers = validator.validateAndGetLottoNumber("1,2,3,4,5,6");
        assertThat(integers.size()).isEqualTo(6);
        assertThat(integers).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
    @Test
    public void 비정상_로또번호_빈_문자열() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetLottoNumber(""));
    }
    @Test
    public void 비정상_로또번호_공백_문자열() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetLottoNumber("  "));
    }
    @Test
    public void 비정상_로또번호_번호_개수_부족() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetLottoNumber("1,2,3,4"));
    }
    @Test
    public void 비정상_로또번호_숫자_이외의_문자_포함() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetLottoNumber("d,1,2,3"));
    }
    @Test
    public void 비정상_로또번호_쉼표_연속으로_존재() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetLottoNumber("1,,2,3"));
    }
    @Test
    public void 비정상_로또번호_쉼표_이외의_구분자() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetLottoNumber("1;2;3"));
    }
    @Test
    public void 정상_보너스번호() throws Exception{
        int bonusNumber = validator.validateAndGetBonusNumber("7");
        assertThat(bonusNumber).isEqualTo(7);
    }
    @Test
    public void 비정상_보너스번호_범위_이탈() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetBonusNumber("0"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetBonusNumber("1515"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetBonusNumber("-1"));
    }
    @Test
    public void 비정상_보너스번호_빈_문자열() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetBonusNumber(""));
    }
    @Test
    public void 비정상_보너스번호_공백_문자열() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetBonusNumber("    "));
    }
    @Test
    public void 비정상_보너스번호_숫자_아닌_문자_포함() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetBonusNumber("5as"));
    }
}

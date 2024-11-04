package lotto.model;

import lotto.exception.BonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberTest {
    @DisplayName("당첨 로또 번호에 포함된 보너스 번호 입력 시 오류")
    @Test
    void 당첨_로또_번호에_포함된_보너스_번호_입력_시_오류(){
        //given
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,6");
        //when
        //then
        assertThrows(BonusNumberException.class, ()->{
            BonusNumber.of("1", winningLottoNumber);
        });
    }

    @DisplayName("음수 보너스 번호 입력 시 오류")
    @Test
    void 음수_보너스_번호_입력_시_오류(){
        //given
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,6");
        //when
        //then
        assertThrows(BonusNumberException.class, ()->{
            BonusNumber.of("-1", winningLottoNumber);
        });
    }

    @DisplayName("45이상 보너스 번호 입력 시 오류")
    @Test
    void 범위_초과_보너스_번호_입력_시_오류(){
        //given
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,6");
        //when
        //then
        assertThrows(BonusNumberException.class, ()->{
            BonusNumber.of("46", winningLottoNumber);
        });
    }

    @DisplayName("정수 아닌 보너스 번호 입력 시 오류")
    @Test
    void 정수_아닌_보너스_번호_입력_시_오류(){
        //given
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,6");
        //when
        //then
        assertThrows(BonusNumberException.class, ()->{
            BonusNumber.of("7.7", winningLottoNumber);
        });
    }

    @DisplayName("null 보너스 번호 입력 시 오류")
    @Test
    void null_보너스_번호_입력_시_오류(){
        //given
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,6");
        //when
        //then
        assertThrows(BonusNumberException.class, ()->{
            BonusNumber.of(null, winningLottoNumber);
        });
    }

    @DisplayName("보너스 번호 getter 성공")
    @Test
    void 보너스_번호_getter_성공(){
        //given
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.of("7", winningLottoNumber);
        //when
        //then
        assertEquals(7, bonusNumber.getBonusNumber());
    }
}

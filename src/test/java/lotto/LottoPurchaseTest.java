package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoPurchaseTest {
    private LottoPurchase lottoPurchase;

    @Test
    @BeforeEach
    void setup(){
        lottoPurchase = new LottoPurchase();
    }

    @Test
    void 구입금액이_1000원_단위로_나누어_떨어지지_않으면_예외가_발생한다(){
        //when
        Throwable thrown = catchException(()->lottoPurchase.inputAmount("11111"));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 구입금액에_숫자가_아닌값을_입력받으면_예외가_발생한다(){
        //when
        Throwable thrown = catchException(()->lottoPurchase.inputAmount("111aa"));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 구입금액에_1000원_미만으로_입력받으면_예외가_발생한다(){
        //when
        Throwable thrown = catchException(()->lottoPurchase.inputAmount("999"));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 로또번호_입력값이_숫자와_쉼표로_구분된_문자열이_아니면_예외가_발생한다(){
        //given
        String userInputLottoNumber = "1,2,3,4;5,a,7";
        String userInputBonusNumber = "7";
        //when
        Throwable thrown = catchException(()->lottoPurchase.inputLottoNumber(userInputLottoNumber,userInputBonusNumber));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다(){
        //given
        String userInputLottoNumber = "1,2,3,4,5,6";
        String userInputBonusNumber = "a";
        //when
        Throwable thrown = catchException(()->lottoPurchase.inputLottoNumber(userInputLottoNumber,userInputBonusNumber));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_입력되면_당첨로또_변수에_담긴다(){
        //given
        String userInputLottoNumber = "1,2,3,4,5,6";
        String userInputBonusNumber = "8";
        //when
        lottoPurchase.inputLottoNumber(userInputLottoNumber,userInputBonusNumber);
        WinningLotto result = lottoPurchase.getWinningLotto();
        //then
        assertThat(result.getNumbers()).isEqualTo(new WinningLotto(List.of(1,2,3,4,5,6),8).getNumbers());

    }
}

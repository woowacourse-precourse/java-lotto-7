package model;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private WinningLottoNum winningLottoNum;
    @BeforeEach
    public void initWinningLottoNum(){
        List<Integer> list = List.of(1,2,3,4,5,10);
        winningLottoNum = new WinningLottoNum(list);
    }

    @Test
    void 보너스숫자_생성_테스트(){
        String input = "7";

        BonusNumber bonusNumber = new BonusNumber(winningLottoNum,input);

        assertThat(bonusNumber.get()).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스숫자 실패 테스트 : 입력이 숫자가 아닐 때")
    void 보너스숫자_실패_테스트1(){
        String input = "a";

        assertThatThrownBy(()->new BonusNumber(winningLottoNum,input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스숫자 실패 테스트 : 입력이 유효 범위의 최소치보다 작을 때")
    void 보너스숫자_실패_테스트2(){
        String input = "0";

        assertThatThrownBy(()->new BonusNumber(winningLottoNum,input))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("보너스숫자 실패 테스트 : 입력이 유효 범위의 최대치보다 클 때")
    void 보너스숫자_실패_테스트3(){
        String input = "50";

        assertThatThrownBy(()->new BonusNumber(winningLottoNum,input))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("보너스숫자 실패 테스트 : 입력이 당첨 번호에 존재할 때")
    void 보너스숫자_실패_테스트4(){
        String input = "4";

        assertThatThrownBy(()->new BonusNumber(winningLottoNum,input))
            .isInstanceOf(IllegalArgumentException.class);

    }
}

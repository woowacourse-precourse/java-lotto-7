package factory;

import model.WinningLottoNum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumFactoryTest {

    @Test
    void 당첨번호_성공_테스트1() {
        String input = "1,2,3,4,5,6";
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(input);

        WinningLottoNum winningLottoNum = winningLottoNumFactory.get();

        assertThat(winningLottoNum).isInstanceOf(WinningLottoNum.class);
        assertThat(winningLottoNum.getWinningNums()
            .stream().distinct().toList().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호 성공 테스트 : 쉼표 다음 공백이 있는 경우")
    void 당첨번호_성공_테스트2() {
        String input = "1, 2, 3, 4,5,6";
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(input);

        WinningLottoNum winningLottoNum = winningLottoNumFactory.get();

        assertThat(winningLottoNum).isInstanceOf(WinningLottoNum.class);
        assertThat(winningLottoNum.getWinningNums()
            .stream().distinct().toList().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호 실패 테스트 : 숫자 이외의 값이 있는 경우")
    void 당첨번호_실패_테스트1() {
        String input = "1, 2, 3, 4,5,a";
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(input);

        assertThatThrownBy(
            () -> winningLottoNumFactory.get()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 실패 테스트 : 숫자가 6개가 아닐 경우")
    void 당첨번호_실패_테스트2() {
        String input = "1, 2, 3, 4,5";
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(input);

        assertThatThrownBy(
            () -> winningLottoNumFactory.get()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 실패 테스트 : 숫자가 중복될 경우")
    void 당첨번호_실패_테스트3() {
        String input = "1, 2, 3, 4,5,5";
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(input);

        assertThatThrownBy(
            () -> winningLottoNumFactory.get()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 실패 테스트 : 숫자의 범위가 45보다 클 경우")
    void 당첨번호_실패_테스트4() {
        String input = "1, 2, 3, 4,5,100";
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(input);

        assertThatThrownBy(
            () -> winningLottoNumFactory.get()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 실패 테스트 : 숫자의 범위가 1보다 작을 경우")
    void 당첨번호_실패_테스트5() {
        String input = "-1, 2, 3, 4,5,1";
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(input);

        assertThatThrownBy(
            () -> winningLottoNumFactory.get()
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

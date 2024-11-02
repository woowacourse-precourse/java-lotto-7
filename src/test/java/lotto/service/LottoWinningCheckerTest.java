package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoWinningCheckerTest {
    public LottoWinningChecker lottoWinningChecker;
    @BeforeEach
    public void init() {
        lottoWinningChecker = new LottoWinningChecker();
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void 당첨번호_입력_테스트(int input) throws Exception {
        //given
        lottoWinningChecker.setWinningNumbs("1,2,3,4,5,6");
        //when
        //then
        Assertions.assertThat(lottoWinningChecker.getWinningNumbs()).contains(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void 당첨번호_공백포함입력_테스트(int input) throws Exception {
        //given
        lottoWinningChecker.setWinningNumbs("1,2, 3,4,5,6");
        //when
        //then
        Assertions.assertThat(lottoWinningChecker.getWinningNumbs()).contains(input);
    }

    @Test
    public void 당첨번호에_숫자를_입력하지_않는_예외_테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("1,2,3,4,5,6a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요");
    }

    @Test
    public void 당첨번호에_숫자에_공백을_입력한_경우_예외_테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("1,2,3,4,5, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열을 입력하였습니다.");
    }

    @Test
    public void 당첨번호에_숫자에_공백을_입력한_경우_예외_테스트2() throws Exception {
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("1,2,3, ,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열을 입력하였습니다.");
    }
    
    @Test
    public void 당첨번호가_5개인_경우_예외테스트() throws Exception{
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개 이어야 합니다.");
        
    }

    @Test
    public void 당첨번호가_7개인_경우_예외테스트() throws Exception{
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개 이어야 합니다.");

    }

    @Test
    public void 당첨번호에_45보다_큰수가_입력된_경우_예외테스트() throws Exception{
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @Test
    public void 당첨번호에_1보다_작은수가_입력된_경우_예외테스트() throws Exception{
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("0,2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @Test
    public void 당첨번호에_음수가_입력된_경우_예외테스트() throws Exception{
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.setWinningNumbs("1,-2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }
}
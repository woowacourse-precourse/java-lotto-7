package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoWinningCheckerTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public LottoWinningChecker lottoWinningChecker;
    @BeforeEach
    public void init() {
        lottoWinningChecker = new LottoWinningChecker();
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void 당첨번호_저장_테스트(int input) throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2,3,4,5,6");
        //when
        lottoWinningChecker.saveWinningNumbs(winningNumbs);
        //then
        Assertions.assertThat(lottoWinningChecker.getWinningNumbs()).contains(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void 당첨번호_공백포함입력_저장_테스트(int input) throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2, 3,4,5,6");
        //when
        lottoWinningChecker.saveWinningNumbs(winningNumbs);
        //then
        Assertions.assertThat(lottoWinningChecker.getWinningNumbs()).contains(input);
    }

    @Test
    public void 보너스번호_저장_테스트() throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2, 3,4,5,6");
        lottoWinningChecker.saveWinningNumbs(winningNumbs);
        int bonusNumber = Parser.parseBonusNum("7");
        //when
        lottoWinningChecker.saveBonusNumber(bonusNumber);
        //then
        Assertions.assertThat(lottoWinningChecker.getBonusNumber()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","5","6"})
    public void 보너스번호_중복된_번호_예외테스트(String input) throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2, 3,4,5,6");
        lottoWinningChecker.saveWinningNumbs(winningNumbs);
        int bonusNumber = Parser.parseBonusNum(input);
        //when
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.saveBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE+"보너스 번호가 당첨번호와 중복됩니다.");
    }

}
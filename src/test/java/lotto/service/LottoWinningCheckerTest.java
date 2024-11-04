package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.utils.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoWinningCheckerTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public LottoWinningChecker lottoWinningChecker;

    @BeforeEach
    public void init() {
        lottoWinningChecker = new LottoWinningChecker();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void 당첨번호_저장_테스트(int input) throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2,3,4,5,6");
        //when
        lottoWinningChecker.saveWinningNumbs(winningNumbs);
        //then
        Assertions.assertThat(lottoWinningChecker.getWinningNumbs()).contains(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
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
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    public void 보너스번호_중복된_번호_예외테스트(String input) throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2, 3,4,5,6");
        lottoWinningChecker.saveWinningNumbs(winningNumbs);
        int bonusNumber = Parser.parseBonusNum(input);
        //when
        Assertions.assertThatThrownBy(() -> lottoWinningChecker.saveBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + "보너스 번호가 당첨번호와 중복됩니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6',FIRST",
            "'1,2,3,4,5,7',SECOND",
            "'1,2,3,4,5,45',THIRD",
            "'1,2,3,4,44,45',FOURTH",
            "'1,2,3,43,44,45',FIFTH",
            "'1,2,42,43,44,45',NONE",
    })
    public void 당첨_여부_확인_테스트(String inputLottoNumbs, String rankName) throws Exception {
        //given
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String s : inputLottoNumbs.split(",")) {
            int i = Integer.parseInt(s);
            lottoNumbers.add(i);
        }
        Lotto lotto = new Lotto(lottoNumbers);
        lottoWinningChecker.saveWinningNumbs(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoWinningChecker.saveBonusNumber(7);
        //when
        LottoRank lottoRank = lottoWinningChecker.checkRank(lotto);
        //then
        Assertions.assertThat(lottoRank.name()).isEqualTo(rankName);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6',2_000_000_000",
            "'1,2,3,4,44,45',50_000",
            "'1,2,42,43,44,45',0",
    })
    public void 당첨_금액_테스트(String inputLottoNumbs, int prize) throws Exception {
        //given
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String s : inputLottoNumbs.split(",")) {
            int i = Integer.parseInt(s);
            lottoNumbers.add(i);
        }
        Lotto lotto = new Lotto(lottoNumbers);
        lottoWinningChecker.saveWinningNumbs(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoWinningChecker.saveBonusNumber(7);
        //when
        LottoRank lottoRank = lottoWinningChecker.checkRank(lotto);
        //then
        Assertions.assertThat(lottoRank.getPrize()).isEqualTo(prize);
    }
}
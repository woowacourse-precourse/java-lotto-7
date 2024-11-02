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
}
package lotto.Model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Constants;
import org.junit.jupiter.api.Test;

class LottoWinningNumberValidatorTest {
    @Test
    void 당첨번호는_공백이_입력되면안된다(){
        assertThatThrownBy(()-> new LottoWinningNumberValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.WINNING_NUMS_INPUT_BLANK_ERROR);
    }

    @Test
    void 당첨번호는_문자열이_입력되서는안된다(){
        assertThatThrownBy(()-> new LottoWinningNumberValidator("1,2,3,f,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.WINNING_NUMS_PARSING_ERROR);
    }

    @Test
    void 당첨번호는_1과_45사이의_숫자여야한다(){
        assertThatThrownBy(()-> new LottoWinningNumberValidator("46,1,3,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.WINNING_NUMS_RANGE_ERROR);
    }

    @Test
    void 당첨번호는_6개의_숫자여야한다(){
        assertThatThrownBy(() -> new LottoWinningNumberValidator("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.WINNING_NUMS_SIZE_ERROR);
    }

    @Test
    void 당첨번호에는_중복된_숫자가_없어야한다(){
        assertThatThrownBy(() -> new LottoWinningNumberValidator("1,1,2,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.WINNING_NUMS_DUPLICATE_ERROR);
    }
}
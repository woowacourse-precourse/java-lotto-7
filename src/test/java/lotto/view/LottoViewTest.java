package lotto.view;


import java.util.stream.Stream;
import lotto.constant.PrizeTier;
import lotto.utils.NumberList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoViewTest {
    LottoView lottoView;
    @BeforeEach
    void init(){
        lottoView = new LottoView();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","","3001","1234","5000000000000"})
    void testValidateMoney(String inputMoney){
        assertThatThrownBy(()->lottoView.validateMoney(inputMoney)).isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @ValueSource(strings ={"1,2,3,4,5","1,2,3,4,5,500","1,2,3,4,5,~","","1,2,3,4,5,~","1,2,3,4,5,5","1,2,3,4,5,0"})
    void testValidateWinningNumbers(String inputWinningNumbers){
        assertThatThrownBy(()->lottoView.validateWinningNumbers(inputWinningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"","?","1j","100","0","-1","a"})
    void testValidateBonusNumber(String inputBonusNumber){
        assertThatThrownBy(()->lottoView.validateBonusNumber(inputBonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}

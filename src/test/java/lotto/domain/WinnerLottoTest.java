package lotto.domain;

import static lotto.utils.ErrorMessage.INVALID_BONUS_NUM;
import static lotto.utils.ErrorMessage.INVALID_LOTTO_NUM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class WinnerLottoTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("예외 : null 공백 입력")
    void test1(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 순서가 달라도 숫자가 같으면 똑같이 반환한다.")
    void test2() {
        WinnerLotto winnerLotto1 = new WinnerLotto("1,2,3,4,5,6");
        winnerLotto1.addBonusNumber(new LottoNumber("7"));

        WinnerLotto winnerLotto2 = new WinnerLotto("6,5,4,3,2,1");
        winnerLotto2.addBonusNumber(new LottoNumber("7"));

        assertThat(winnerLotto1).isEqualTo(winnerLotto2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5,1"})
    @DisplayName("예외 : 중복 입력")
    void test3(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("예외 : 6자 미만 초과")
    void test4(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5,6,", "1,,2,3,4,5,6", ",1,2,3,4,5,6", "1,2,3,4,5,6,"})
    @DisplayName("예외 : 비정상 구분자")
    void test5(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    @DisplayName("예외 : 로또 숫자 범위 초과")
    void test6(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a,2,3,4,5,6", "1,2,3,4,5,6a", "1,2,3,4,5!,6", "1!2,3,4,5a6"})
    @DisplayName("예외 : 문자 추가")
    void test7(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("성공 : 위너 넘버 + 보너스 넘버")
    @CsvSource(value = {
            "1,2,3,4,5,6:7",
            "1,45,2,3,4,5:7"
    }, delimiter = ':')
    void test8(String winnerNums, String bonusNum) {
        WinnerLotto winnerLotto = new WinnerLotto(winnerNums);

        winnerLotto.addBonusNumber(new LottoNumber(bonusNum));

        assertThat(winnerLotto).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("예외 : 위너 넘버 + 보너스 넘버")
    @CsvSource(value = {
            "1,2,3,4,5,6:46",
            "1,2,3,4,5,6:-1",
            "1,2,3,4,5,6:0"
    }, delimiter = ':')
    void test9(String winnerNums, String bonusNum) {
        WinnerLotto winnerLotto = new WinnerLotto(winnerNums);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber lottoNumber = new LottoNumber(bonusNum);
            winnerLotto.addBonusNumber(lottoNumber);
        });

        assertThat(exception.getMessage()).isEqualTo(INVALID_LOTTO_NUM.toString());
    }

    @ParameterizedTest
    @DisplayName("중복 예외 : 위너 넘버 + 보너스 넘버")
    @CsvSource(value = {
            "1,2,3,4,5,6:1",
            "1,2,3,4,5,6:5"
    }, delimiter = ':')
    void test10(String winnerNums, String bonusNum) {
        WinnerLotto winnerLotto = new WinnerLotto(winnerNums);
        LottoNumber lottoNumber = new LottoNumber(bonusNum);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            winnerLotto.addBonusNumber(lottoNumber);
        });

        assertThat(exception.getMessage()).isEqualTo(INVALID_BONUS_NUM.toString());
    }

    @Test
    @DisplayName("보너스 넘버 존재 테스트")
    void test11() {
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6");
        assertThrows(IllegalStateException.class, winnerLotto::validBonusNumber);

        winnerLotto.addBonusNumber(new LottoNumber("7"));
        assertThat(winnerLotto).isNotNull();
    }
}

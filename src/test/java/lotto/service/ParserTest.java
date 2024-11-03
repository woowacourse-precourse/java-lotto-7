package lotto.service;

import java.util.List;
import lotto.utils.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void 당첨번호_입력_테스트(int input) throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2,3,4,5,6");
        //then
        Assertions.assertThat(winningNumbs).contains(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void 당첨번호_공백포함입력_테스트(int input) throws Exception {
        //given
        List<Integer> winningNumbs = Parser.parseWinningNumbs("1,2, 3,4,5,6");
        //then
        Assertions.assertThat(winningNumbs).contains(input);
    }

    @Test
    public void 당첨번호에_중복된_숫자입력_예외_테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,2,3,4,3,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    public void 당첨번호에_숫자를_입력하지_않는_예외_테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,2,3,4,5,6a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    public void 당첨번호에_숫자에_공백을_입력한_경우_예외_테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,2,3,4,5, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열을 입력하였습니다.");
    }

    @Test
    public void 당첨번호에_숫자에_공백을_입력한_경우_예외_테스트2() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,2,3, ,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열을 입력하였습니다.");
    }

    @Test
    public void 당첨번호가_5개인_경우_예외테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개 이어야 합니다.");

    }

    @Test
    public void 당첨번호가_7개인_경우_예외테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개 이어야 합니다.");

    }

    @Test
    public void 당첨번호에_45보다_큰수가_입력된_경우_예외테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @Test
    public void 당첨번호에_1보다_작은수가_입력된_경우_예외테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("0,2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @Test
    public void 당첨번호에_음수가_입력된_경우_예외테스트() throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumbs("1,-2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @Test
    public void 보너스번호_정상입력_테스트() throws Exception {
        //given
        int bonusNum = Parser.parseBonusNum("4");
        //then
        Assertions.assertThat(bonusNum).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅁ", "a", "/", "-", "\\", "a3"})
    public void 보너스번호_숫자가_아닌_경우_예외테스트(String input) throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseBonusNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "    ", "\3"})
    public void 보너스번호에_빈문자열이_입력된_경우_예외테스트(String input) throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseBonusNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열을 입력하였습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 0", "-1", "-10"})
    public void 보너스번호_1보다_작은수가_입력된_경우_예외테스트(String input) throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseBonusNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "1000", "134534534"})
    public void 보너스번호_1보다_큰수가_입력된_경우_예외테스트(String input) throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseBonusNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "59000"})
    public void 로또_금액에_1000원_단위_입력_테스트(String input) throws Exception {
        //given
        int money = Parser.parseMoney(input);
        //when
        //then
        Assertions.assertThat(money).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10021312"})
    public void 로또_금액에_0원이하_입력_예외테스트(String input) throws Exception {
        Assertions.assertThatThrownBy(() -> Parser.parseMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] " + "금액은 양수이어야 합니다.");
    }
}

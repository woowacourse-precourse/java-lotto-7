package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoNumberSelectorTest {

    @ParameterizedTest
    @MethodSource("winningNumberMatching")
    @DisplayName("로또 번호 매칭 갯수 확인")
    public void 로또_번호_매칭_갯수(Lotto lotto,int result){
        //given
        WinningNumber winningNumber = new WinningNumber(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),new SpecialNumber("7"));
        WinningLottoNumberSelector winningLottoNumberSelector = new WinningLottoNumberSelector(winningNumber,
                List.of(lotto));

        //when
        int matchNumber = winningLottoNumberSelector.matchNumber(winningLottoNumberSelector.getPurchasedLottos().get(0));

        //then
        assertThat(matchNumber).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("winningNumberContainBonus")
    @DisplayName("로또 번호 보너스 번호 포함 여부 확인")
    public void 로또_보너스_포함_여부(Lotto lotto,boolean result){
        //given
        WinningNumber winningNumber = new WinningNumber(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),new SpecialNumber("7"));
        WinningLottoNumberSelector winningLottoNumberSelector = new WinningLottoNumberSelector(winningNumber,
                List.of(lotto));

        //when
        boolean containSpecialNumber = winningLottoNumberSelector.containSpecialNumber(
                winningLottoNumberSelector.getPurchasedLottos().get(0));

        //then
        assertThat(containSpecialNumber).isEqualTo(result);
    }

    static Stream<Arguments> winningNumberMatching(){
        return Stream.of(
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),6),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,4,5,7"),5),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,4,8,7"),4),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,9,8,7"),3),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,9,11,8,7"),2),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,10,9,13,8,7"),1),
                Arguments.arguments(Lotto.createWinningRegularLotto("11,10,9,15,8,7"),0)
        );
    }

    static Stream<Arguments> winningNumberContainBonus(){
        return Stream.of(
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),false),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,4,5,8"),false),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,4,8,7"),true),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,3,9,8,7"),true),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,2,9,11,8,7"),true),
                Arguments.arguments(Lotto.createWinningRegularLotto("1,10,9,13,8,7"),true),
                Arguments.arguments(Lotto.createWinningRegularLotto("11,10,9,15,8,7"),true)
        );
    }

}
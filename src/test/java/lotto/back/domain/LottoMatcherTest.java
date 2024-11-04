package lotto.back.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.global.enums.WinningLottoRank;
import lotto.global.exception.DuplicatedLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

class LottoMatcherTest {

    @ParameterizedTest
    @MethodSource("validNumberParams")
    @DisplayName("로또 번호, 추첨번호, 보너스 번호에 대한 LottoDrawer 객체 생성")
    void 객체_생성_테스트(List<Lotto> lotto, DrawnNumbers drawnNumbers, LottoNumber bonusNumber) {
        //given
        //when
        LottoMatcher lottoMatcher = new LottoMatcher(lotto, drawnNumbers, bonusNumber);
        //then
        assertThat(lottoMatcher).isNotNull();
    }

    private static Stream<Arguments> validNumberParams() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        new DrawnNumbers(List.of(10, 20, 30, 15, 25, 35)),
                        new LottoNumber(7)));
    }

    @ParameterizedTest
    @MethodSource("invalidDrawNumbersAndBonusNumber")
    @DisplayName("로또번호는 정상이지만 추첨 번호와 보너스 번호가 중복될 때 예외 발생")
    void 객체_생성_예외_테트(List<Lotto> lotto, DrawnNumbers drawnNumbers, LottoNumber bonusNumber) {
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            new LottoMatcher(lotto, drawnNumbers, bonusNumber);
        }).isInstanceOf(DuplicatedLottoNumberException.class);
    }

    private static Stream<Arguments> invalidDrawNumbersAndBonusNumber() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        new DrawnNumbers(List.of(10, 20, 30, 15, 25, 35)),
                        new LottoNumber(35)));
    }

    @ParameterizedTest
    @MethodSource("winningParamsResultParams")
    @DisplayName("로또 번호, 추첨 번호, 보너스 번호에 대해 추첨을 실행하고 결과를 반환")
    void 추첨_결과_테스트(List<Lotto> lotto, DrawnNumbers drawnNumbers, LottoNumber bonusNumber, WinningLottoRank rank) {
        //given
        LottoMatcher lottoMatcher = new LottoMatcher(lotto, drawnNumbers, bonusNumber);
        //when
        Map<WinningLottoRank, Integer> winningCount = lottoMatcher.getWinningResult();
        //then
        // 주어진 번호들에 대해 winningCount 객체 count가 잘 set 됐는지 확인
        assertThat(winningCount.get(rank)).isEqualTo(1);
        // 다른 winningCount 객체들의 count가 모두 0인지 확인
        assertThat(winningCount.entrySet().stream().filter(entry -> entry.getKey() != rank)
                .allMatch(entry -> entry.getValue() == 0)).isTrue();
    }

    private static Stream<Arguments> winningParamsResultParams() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        new DrawnNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(35),
                        WinningLottoRank.FIRST_PLACE),
                Arguments.of(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        new DrawnNumbers(List.of(1, 2, 3, 4, 5, 35)),
                        new LottoNumber(6),
                        WinningLottoRank.SECOND_PLACE),
                Arguments.of(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 10, 6))),
                        new DrawnNumbers(List.of(1, 2, 3, 4, 10, 35)),
                        new LottoNumber(45),
                        WinningLottoRank.THIRD_PLACE),
                Arguments.of(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 11, 6))),
                        new DrawnNumbers(List.of(1, 2, 3, 4, 10, 35)), new LottoNumber(45),
                        WinningLottoRank.FOURTH_PLACE),
                Arguments.of(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        new DrawnNumbers(List.of(1, 2, 3, 15, 25, 35)), new LottoNumber(40),
                        WinningLottoRank.FIFTH_PLACE));
    }

    @ParameterizedTest
    @MethodSource("secondAndThirdPlaceParams")
    @DisplayName("2등과 3등을 잘 가리는지 단위 테스트")
    void 이등_삼등_계산_테스트(List<Lotto> lotto, DrawnNumbers drawnNumbers, LottoNumber bonusNumber) {
        //given
        //when
        LottoMatcher lottoMatcher = new LottoMatcher(lotto, drawnNumbers, bonusNumber);
        Map<WinningLottoRank, Integer> winningCount = lottoMatcher.getWinningResult();
        //then
        assertThat(winningCount.get(WinningLottoRank.SECOND_PLACE)).isEqualTo(1);
        assertThat(winningCount.get(WinningLottoRank.THIRD_PLACE)).isEqualTo(1);
        assertThat(winningCount.entrySet().stream().filter(entry -> entry.getKey() != WinningLottoRank.SECOND_PLACE
                && entry.getKey() != WinningLottoRank.THIRD_PLACE).allMatch(entry -> entry.getValue() == 0)).isTrue();
    }

    private static Stream<Arguments> secondAndThirdPlaceParams() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                        new DrawnNumbers(List.of(1, 2, 3, 4, 5, 10)),
                        new LottoNumber(7)));
    }
}
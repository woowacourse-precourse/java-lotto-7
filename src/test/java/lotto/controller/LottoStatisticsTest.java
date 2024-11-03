package lotto.controller;

import static java.util.Arrays.stream;
import static lotto.controller.LottoStatistics.getStatistics;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.MatchingRecord;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStatisticsTest {
    private final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    private final BonusNumber bonusNumber = new BonusNumber(winningNumbers, 7);

    private static Stream<Arguments> lottoesAndRank() {
        return Stream.of(
                Arguments.arguments("3개 매칭", new Lotto(List.of(1, 2, 3, 9, 10, 11)), 0),
                Arguments.arguments("3개 매칭 보너스", new Lotto(List.of(1, 2, 3, 7, 10, 11)), 0),
                Arguments.arguments("4개 매칭", new Lotto(List.of(1, 2, 3, 4, 9, 10)), 1),
                Arguments.arguments("4개 매칭 보너스", new Lotto(List.of(1, 2, 3, 4, 7, 10)), 1),
                Arguments.arguments("5개 매칭", new Lotto(List.of(1, 2, 3, 4, 5, 9)), 2),
                Arguments.arguments("5개 매칭 보너스", new Lotto(List.of(1, 2, 3, 4, 5, 7)), 3),
                Arguments.arguments("6개 매칭", new Lotto(List.of(1, 2, 3, 4, 5, 6)), 4)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("lottoesAndRank")
    @DisplayName("로또와 당첨 번호 매칭 기록 기능 테스트")
    void 로또_매칭_테스트(String testName, Lotto lotto, int index) {
        List<Lotto> lottoes = new ArrayList<>();
        lottoes.add(lotto);

        List<MatchingRecord> matchingRecords = stream(Rank.values()).map(MatchingRecord::new).toList();
        getStatistics(matchingRecords, lottoes, winningNumbers, bonusNumber);
        assertThat(matchingRecords.get(index).getLottoQuantity()).isEqualTo(1);
    }
}
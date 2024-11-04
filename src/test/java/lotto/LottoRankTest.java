package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    static Integer bonusNumber = 7;
    @ParameterizedTest
    @MethodSource("getLottoRankAndLotto")
    void of(LottoRank lottoRank, Lotto lotto) {
        assertThat(LottoRank.of(lotto, LottoTest.winner,bonusNumber)).isEqualTo(lottoRank);
    }

    @ParameterizedTest
    @MethodSource("lottoRankValueAndCondition")
    void getInstruction(LottoRank rank, String instruction) {
        assertThat(rank.getConditionInstruction()).isEqualTo(instruction);
    }

    private static Stream<Arguments> getLottoRankAndLotto() {
        return Stream.of(
                Arguments.of(LottoRank.FIRST, new Lotto(List.of(1,2,3,4,5,6))),
                Arguments.of(LottoRank.SECOND, new Lotto(List.of(1,2,3,4,5,7))),
                Arguments.of(LottoRank.THIRD, new Lotto(List.of(1,2,3,4,5,45))),
                Arguments.of(LottoRank.FOURTH, new Lotto(List.of(1,2,3,4,44,45))),
                Arguments.of(LottoRank.FIFTH, new Lotto(List.of(1,2,3,43,44,45))),
                Arguments.of(LottoRank.NONE, new Lotto(List.of(1,2,42,43,44,45)))
        );
    }

    private static List<Arguments> lottoRankValueAndCondition() {
        return List.of(
                Arguments.of(LottoRank.FIRST, "6개 일치 (2,000,000,000원)"),
                Arguments.of(LottoRank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
                Arguments.of(LottoRank.THIRD, "5개 일치 (1,500,000원)"),
                Arguments.of(LottoRank.FOURTH, "4개 일치 (50,000원)"),
                Arguments.of(LottoRank.FIFTH, "3개 일치 (5,000원)"),
                Arguments.of(LottoRank.NONE, null)
        );
    }
}
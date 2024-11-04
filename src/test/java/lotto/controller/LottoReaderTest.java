package lotto.controller;

import static lotto.controller.LottoReader.computeSingleLottoResult;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.utils.LottoRank;

public class LottoReaderTest {

    private static final Stream<Arguments> normalComputeSingleLottoResultArguments() {
        return Stream.of(
            Arguments.arguments("3개 일치인 경우",
                List.of(1,2,3,4,5,6), 
                List.of(1,2,3,14,15,10), 
                6, LottoRank.MATCH_3),
            Arguments.arguments("4개 일치인 경우",
                List.of(1,2,3,4,5,6), 
                List.of(1,2,3,4,15,10), 
                6, LottoRank.MATCH_4),
            Arguments.arguments("5개 일치, 보너스 번호 일치하지 않는 경우",
                List.of(1,2,3,4,5,6), 
                List.of(1,2,3,4,5,10), 
                16, LottoRank.MATCH_5),
            Arguments.arguments("5개 일치, 보너스 번호 일치인 경우",
                List.of(1,2,3,4,5,6), 
                List.of(1,2,3,4,5,10), 
                6, LottoRank.MATCH_5_AND_BONUS),
            Arguments.arguments("6개 일치인 경우",
                List.of(1,2,3,4,5,6), 
                List.of(1,2,3,4,5,6), 
                7, LottoRank.MATCH_6)
        );
    }

    @DisplayName("computeSingleLottoResult 메소드 정상 기능 테스트")
    @ParameterizedTest(name = "{0}")
    @MethodSource("normalComputeSingleLottoResultArguments")
    void normalComputeSingleLottoResultTest(String caseName, List<Integer> lottoNumbersArgument, List<Integer> winningNumbersArgument, Integer bonusNumberArgument, LottoRank lottoRankArgument) {
        Lotto lotto = new Lotto(lottoNumbersArgument);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersArgument);
        BonusNumber bonusNumber = new BonusNumber(winningNumbers.getWinningNumbers(), bonusNumberArgument);

        assertThat(computeSingleLottoResult(lotto, winningNumbers, bonusNumber)).isEqualTo(lottoRankArgument);
    }
}

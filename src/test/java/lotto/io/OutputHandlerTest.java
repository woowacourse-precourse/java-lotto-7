package lotto.io;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.testutil.WriterFake;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputHandlerTest {

    @Test
    void 사용자가_구매한_로또_번호_출력_테스트() {
        //given
        WriterFake writerFake = new WriterFake();
        OutputHandler outputHandler = new OutputHandler(
                writerFake,
                new UserLottoParser(),
                new WinningResultParser()
        );

        //when
        outputHandler.userLottoHandle(getUserLotto());

        //then
        Assertions.assertThat(writerFake.getOutputs()).containsExactly(
                """
                                                
                        3개를 구매했습니다.
                        [1, 2, 3, 4, 5, 6]
                        [7, 8, 9, 10, 11, 12]
                        [13, 14, 15, 16, 17, 18]
                                                
                        """
        );
    }

    private UserLotto getUserLotto() {
        List<Lotto> lottos = new ArrayList<>();

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));

        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);

        UserLotto userLotto = new UserLotto(3, lottos);
        return userLotto;
    }

    @Test
    void 당첨_결과_출력_테스트() {
        //given
        WriterFake writerFake = new WriterFake();
        OutputHandler outputHandler = new OutputHandler(
                writerFake,
                new UserLottoParser(),
                new WinningResultParser()
        );

        //when
        outputHandler.winningResultHandle(getWinningResult());

        //then
        Assertions.assertThat(writerFake.getOutputs()).containsExactly(
                """
                                                
                        당첨 통계
                        ---
                        3개 일치 (5,000원) - 1개
                        4개 일치 (50,000원) - 0개
                        5개 일치 (1,500,000원) - 0개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                        6개 일치 (2,000,000,000원) - 0개
                        총 수익률은 62.5%입니다."""
        );
    }

    private WinningResult getWinningResult() {

        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIFTH, 1);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.FIRST, 0);

        long prize = 5_000L;
        double rateOfReturn = 62.5;

        return new WinningResult(result, prize, rateOfReturn);
    }
}
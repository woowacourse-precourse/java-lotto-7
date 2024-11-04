package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberMatcherTest extends NsTest {

    @DisplayName("LottoGame으로부터 로또 게임 결과를 만들어낼 수 있다")
    @Test
    void matchTest() {
        //given
        Lotto firstLotto = Lotto.from("1,2,3,4,5,6");
        Lotto secondLotto = Lotto.from("2,3,4,5,6,45");
        Lotto thirdLotto = Lotto.from("1,2,3,4,5,6");

        Lotto winningNumbers = Lotto.from("1,2,3,4,5,6");

        LottoGame lottoGame = LottoGame.of(
                LottoPrice.valueOf(3000),
                Lottos.of(List.of(firstLotto, secondLotto, thirdLotto)),
                winningNumbers,
                BonusNumber.of("45", winningNumbers));

        //when
        LottoNumberMatcher matcher = LottoNumberMatcher.from(lottoGame);
        matcher.match();

        //then
        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 2개",
                "총 수익률은 134333333.3%입니다."
        );
    }

    @DisplayName("수익률은 소수점 둘째자리에서 반올림한다.")
    @Test
    void matchTest2() {
        //given
        Lotto firstLotto = Lotto.from("1,2,3,4,5,6");
        Lotto secondLotto = Lotto.from("2,3,4,5,6,45");
        Lotto thirdLotto = Lotto.from("1,2,3,4,5,6");

        Lotto winningNumbers = Lotto.from("4,5,6,7,8,9");

        LottoGame lottoGame = LottoGame.of(
                LottoPrice.valueOf(3000),
                Lottos.of(List.of(firstLotto, secondLotto, thirdLotto)),
                winningNumbers,
                BonusNumber.of("45", winningNumbers));

        //when
        LottoNumberMatcher matcher = LottoNumberMatcher.from(lottoGame);
        matcher.match();

        //then
        assertThat(output()).contains(
                "총 수익률은 500.0%입니다."
        );
    }

    @Override
    protected void runMain() {
    }
}
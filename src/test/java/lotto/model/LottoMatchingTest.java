package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoMatchingTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> winningNumbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("4"),
                LottoNumber.valueOf("5"),
                LottoNumber.valueOf("6")
        );
        LottoNumber bonusNumber = LottoNumber.valueOf("7");
        winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    @Test
    void 로또번호가_3개_일치하면_5등이다() {
        List<LottoNumber> userNumbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("10"),
                LottoNumber.valueOf("11"),
                LottoNumber.valueOf("12")
        );
        Lotto userLotto = new Lotto(userNumbers);

        LottoMatching lottoMatching = new LottoMatching(userLotto, winningLotto);
        LottoPrize prize = lottoMatching.getLottoPrize();

        assertThat(prize).isEqualTo(LottoPrize.FIFTH);
    }

    @Test
    void 로또번호가_5개_일치하면_3등이다() {
        List<LottoNumber> userNumbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("4"),
                LottoNumber.valueOf("5"),
                LottoNumber.valueOf("8")
        );
        Lotto userLotto = new Lotto(userNumbers);

        LottoMatching lottoMatching = new LottoMatching(userLotto, winningLotto);
        LottoPrize prize = lottoMatching.getLottoPrize();

        assertThat(prize).isEqualTo(LottoPrize.THIRD);
    }

    @Test
    void 로또번호가_5개_일치하고_보너스번호가_일치하면_2등이다() {
        List<LottoNumber> userNumbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("4"),
                LottoNumber.valueOf("5"),
                LottoNumber.valueOf("7")
        );
        Lotto userLotto = new Lotto(userNumbers);

        LottoMatching lottoMatching = new LottoMatching(userLotto, winningLotto);
        LottoPrize prize = lottoMatching.getLottoPrize();

        assertThat(prize).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    void 로또번호가_6개_일치하면_1등이다() {
        List<LottoNumber> userNumbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("4"),
                LottoNumber.valueOf("5"),
                LottoNumber.valueOf("6")
        );
        Lotto userLotto = new Lotto(userNumbers);

        LottoMatching lottoMatching = new LottoMatching(userLotto, winningLotto);
        LottoPrize prize = lottoMatching.getLottoPrize();

        assertThat(prize).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    void 로또번호가_2개_이하로_일치하면_등수가_없다() {
        List<LottoNumber> userNumbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("10"),
                LottoNumber.valueOf("11"),
                LottoNumber.valueOf("12"),
                LottoNumber.valueOf("13")
        );
        Lotto userLotto = new Lotto(userNumbers);

        LottoMatching lottoMatching = new LottoMatching(userLotto, winningLotto);
        LottoPrize prize = lottoMatching.getLottoPrize();

        assertThat(prize).isEqualTo(LottoPrize.ZERO);
    }

}

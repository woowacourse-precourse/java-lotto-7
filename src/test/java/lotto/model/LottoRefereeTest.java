package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.constant.Rank;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoReferee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoRefereeTest {

    private List<Lotto> inputLottoes;

    @BeforeEach
    void setUp() {
        this.inputLottoes = List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 45),
                new Lotto(1, 9, 42, 43, 44, 45),
                new Lotto(1, 2, 3, 4, 44, 45)
        );
    }

    @Test
    void 당첨결과를_판단한다() {
        LottoReferee pickedLotto = new LottoReferee(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        assertThat(pickedLotto.match(inputLottoes))
                .containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.NONE, Rank.FOURTH);
    }

    @Test
    void 당첨번호와_보너스_번호가_겹치면_예외를_발생시킨다() {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoReferee(winningLotto, bonusNumber));
    }
}

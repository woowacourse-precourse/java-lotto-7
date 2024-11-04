package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_번호와_티켓_번호가_6개_일치() throws Exception{
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int matchingCount = lotto.compareNumberWithTicket(List.of(6,5,4,2,1,3));
        assertThat(matchingCount).isEqualTo(6);
    }
    @Test
    public void 로또_번호와_티켓_번호가_5개_일치() throws Exception{
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int matchingCount = lotto.compareNumberWithTicket(List.of(1, 2, 3, 4, 5, 9));
        assertThat(matchingCount).isEqualTo(5);
    }
    @Test
    public void 로또_번호와_티켓_번호가_4개_일치() throws Exception{
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int matchingCount = lotto.compareNumberWithTicket(List.of(1, 2, 3, 4, 7, 8));
        assertThat(matchingCount).isEqualTo(4);
    }
    @Test
    public void 로또_번호와_티켓_번호가_3개_일치() throws Exception{
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int matchingCount = lotto.compareNumberWithTicket(List.of(1, 2, 3, 7, 8, 9));
        assertThat(matchingCount).isEqualTo(3);
    }
    @Test
    public void 로또_번호와_티켓_번호가_2개_일치() throws Exception{
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int matchingCount = lotto.compareNumberWithTicket(List.of(1, 2, 7, 8, 9, 10));
        assertThat(matchingCount).isEqualTo(2);
    }
    @Test
    public void 로또_번호와_티켓_번호가_1개_일치() throws Exception{
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int matchingCount = lotto.compareNumberWithTicket(List.of(1, 7, 8, 9, 10, 11));
        assertThat(matchingCount).isEqualTo(1);
    }
    @Test
    public void 로또_번호와_티켓_번호가_0개_일치() throws Exception{
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int matchingCount = lotto.compareNumberWithTicket(List.of(7, 8, 9, 10, 11, 12));
        assertThat(matchingCount).isEqualTo(0);
    }
}

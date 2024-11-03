package lotto;

import lotto.common.constant.PrintFormatConst;
import lotto.domain.model.user.Lotto;
import lotto.domain.utils.TestLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Nested
    @DisplayName("print 메서드는")
    class PrintTest {
        @DisplayName("올바른 로또 번호를 형식에 맞게 반환한다.")
        @Test
        void printTest() {
            //given
            String format1 = "1, 2, 3, 4, 5, 6";
            String format2 = "6, 5, 4, 3, 2, 1";

            Lotto lotto1 = TestLotto.createTestLotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto lotto2 = TestLotto.createTestLotto(List.of(6, 5, 4, 3, 2, 1));


            //when
            String print1 = lotto1.print();
            String print2 = lotto2.print();

            //then
            Assertions.assertThat(print1).isEqualTo(
                    String.format(PrintFormatConst.LOTTO_NUMBERS_FORMAT,
                            format1
                    )
            );
            Assertions.assertThat(print2).isEqualTo(
                    String.format(PrintFormatConst.LOTTO_NUMBERS_FORMAT,
                            format2
                    )
            );
        }
    }




}

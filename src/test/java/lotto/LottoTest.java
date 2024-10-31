package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Lotto lotto;
    @BeforeEach
    void setUp() {
        lotto = new Lotto(lotto.generateLotto());

    }
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("발행된 로또를 전달한다")
    @Test
    public void generateTest() throws Exception{
        //given
        List<Integer> given = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> generated = lotto.generateLotto();

        //when
        int expect = given.size();
        int actual = generated.size();

        //then
        Assertions.assertEquals(expect, actual);
    }
    @Test
    @DisplayName("발행해야 되는 수만큼 로또 번호를 생성한다")
    public void generateLotto() throws Exception{
        //given


        //when

        //then
    }
}

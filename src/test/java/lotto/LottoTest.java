package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    void lottoSizeValidateTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    void lottoNumbersDuplicatedValidateTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 1-45 범위 안에 있지 않으면 예외가 발생한다")
    void lottoNumberRangeValidateTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(-11, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 범위 안에서 중복되지 않고 오름차순 정렬되어 저장된다")
    void lottoTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        ArrayList<Integer> numberInput = new ArrayList<>(List.of(6, 7, 1, 2, 40, 30));
        ArrayList<Integer> numberExpected = new ArrayList<>(List.of(1, 2, 6, 7, 30, 40));
        //when
        Lotto lotto = new Lotto(numberInput);
        //then
        assertThatLottoValidated(lotto, numberExpected);
    }

    private static void assertThatLottoValidated(Lotto lotto, ArrayList<Integer> numbers)
            throws NoSuchFieldException, IllegalAccessException {
        // Reflection: private 필드에 접근
        Field numbersField = Lotto.class.getDeclaredField("numbers");
        boolean originalAccessible = numbersField.canAccess(lotto);
        numbersField.setAccessible(true);
        ArrayList<Integer> lottoNumbers = (ArrayList<Integer>) numbersField.get(lotto);
        assertThat(lottoNumbers).isEqualTo(numbers);
        // 접근 제어자 복원
        numbersField.setAccessible(originalAccessible);
    }
}

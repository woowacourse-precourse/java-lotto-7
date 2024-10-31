package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    
    @DisplayName("로또 번호가 1미만, 45초과 일 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_1미만_45초과일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 size가 6이 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호의_size가_6이_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    
    @Test
    @DisplayName("로또의 번호들이 배열형식으로 출력이 되는지 확인하는 테스트")
    void 로또_번호들_배열형식으로_출력이_되는지_확인() {
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        lotto.printLottoNumbers();
        
        // then
        String output = outputStream.toString().trim(); // 출력된 결과를 문자열로 가져옴
        
        assertAll(
                // 대괄호로 시작하고 끝나는지 확인
                () -> assertTrue(output.startsWith("["), "출력은 '['로 시작해야 합니다"),
                () -> assertTrue(output.endsWith("]"), "출력은 ']'로 끝나야 합니다"),
                
                // 숫자들이 포함되어 있는지 확인
                () -> numbers.forEach(number ->
                        assertTrue(output.contains(String.valueOf(number)),
                                String.format("출력에 숫자 %d가 포함되어야 합니다", number))
                )
        );
        
        // 원래 System.out으로 복구
        System.setOut(System.out);
    }
    
}

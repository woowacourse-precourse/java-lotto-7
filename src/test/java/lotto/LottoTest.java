package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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
    
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    // ------------------ inputMoney 관련 테스트 시작 --------------------
    @Test
    @DisplayName("입력한 금액이 1000원 단위가 아니면 예외가 발생한다")
    void 입력한_금액이_1000원_단위가_아니면_예외가_발생한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream("100001\n".getBytes()));
        
        // when & then
        assertThatThrownBy(() -> lotto.playLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 입력하세요.");
    }
    
    @ParameterizedTest // 여러 입력값으로 테스트를 반복 실행
    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다")
    @ValueSource(strings = {"abc", "1,000", "1000원"}) // 테스트할 입력값들
    void 입력값이_숫자가_아닌_경우_예외가_발생한다(String input) { // input 파라미터로 각 테스트 케이스 값이 전달됨
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n").getBytes()));
        
        assertThatThrownBy(() -> lotto.playLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 값은 숫자로 변환할 수 없습니다.");
    }
    
    @ParameterizedTest // 여러 입력값으로 테스트를 반복 실행
    @DisplayName("입력값이 비어있거나 null인 경우 예외가 발생한다")
    @NullAndEmptySource // 이 테스트는 두 번 실행됩니다: null || ""
    void 입력값이_비어있거나_null인경우_예외가_발생한다(String input) { // input 파라미터로 각 테스트 케이스 값이 전달됨
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        
        Console.close();
        System.setIn(new ByteArrayInputStream("\n".getBytes()));  // 엔터키만 입력
        
        assertThatThrownBy(() -> lotto.playLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력한 값이 없습니다.");
    }
    // ------------------ inputMoney 관련 테스트 끝 --------------------
}

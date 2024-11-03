package lotto.view.input;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagerInputViewTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private ManagerInputView managerInputView;

    @BeforeEach
    void setUp() {
        managerInputView = new ManagerInputView();
    }

    @Test
    void 유효한_로또_번호를_입력할_수_있다() {
        // Given: 유효한 로또 번호 입력을 시뮬레이션하기 위해 InputStream 변경
        String input = "1, 2, 3, 4, 5, 6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When: 로또 번호를 가져옴
        List<Integer> lottoNumbers = managerInputView.getLottoNumbers();

        // Then: 입력한 로또 번호가 정확히 반환되어야 함
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

//    @Test
//    void 잘못된_로또_번호를_입력할_경우_예외가_발생한다() {
//        // Given: 잘못된 입력을 시뮬레이션하기 위해 InputStream 변경
//        String input = "1, 2, a, 4, 5, 6"; // 'a'는 잘못된 입력
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        // When: 로또 번호를 가져올 때
//        // Then: IllegalArgumentException이 발생해야 함
//        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
//            managerInputView.getLottoNumbers();
//        });
//
//        // 예외 메시지를 검증
//        assertThat(thrown.getMessage()).contains("숫자 형식의 입력이 필요합니다.");
//    }
//
//    @Test
//    void 잘못된_보너스_번호를_입력할_경우_예외가_발생한다() {
//        // Given: 잘못된 보너스 번호 입력을 시뮬레이션하기 위해 InputStream 변경
//        String input = "b"; // 잘못된 입력
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        // When: 보너스 번호를 가져올 때
//        // Then: IllegalArgumentException이 발생해야 함
//        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
//            managerInputView.getLottoBonusNumber();
//        });
//
//        // 예외 메시지를 검증
//        assertThat(thrown.getMessage()).contains("숫자 형식의 입력이 필요합니다.");
//    }
}

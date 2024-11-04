package lotto.view.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ManagerInputViewTest {
    private ManagerInputView managerInputView;

    @BeforeEach
    void setUp() {
        managerInputView = new ManagerInputView();
    }

    @Test
    @DisplayName("로또 번호를 잘못된 입력 후 다시 입력 여부")
    void 로또번호_잘못된_입력후_다시_입력할_수_있는지_확인() {
        // Given: 잘못된 입력과 올바른 입력을 연속적으로 시뮬레이션
        String input = "1, 2, a, 4, 5, 6\n1, 2, 3, 4, 5, 6"; // 첫 번째는 잘못된 입력, 두 번째는 올바른 입력
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When: 올바른 로또 번호를 가져올 때까지 반복 입력을 받아야 함
        List<Integer> lottoNumbers = managerInputView.getLottoNumbers();

        // Then: 올바른 입력이 입력되었을 때 그 값을 반환하는지 검증
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}

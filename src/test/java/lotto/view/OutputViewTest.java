package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @DisplayName("로또 수량을 지정된 포맷으로 출력한다.")
    @Test
    void 로또_수량을_지정된_포맷으로_출력한다() {
        outputView.printNumberOfLotto(1);
    }
}
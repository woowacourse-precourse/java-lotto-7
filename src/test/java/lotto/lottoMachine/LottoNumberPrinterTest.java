package lotto.lottoMachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private LottoNumberPrinter lottoNumberPrinter;

    @BeforeEach
    void setUp() {
        lottoNumberPrinter = new LottoNumberPrinter();
        System.setOut(new PrintStream(outContent)); // 표준 출력을 캡처하기 위한 설정
    }

    @DisplayName("로또 번호가 기대하는 형식으로 출력되는지 테스트")
    @Test
    void 로또_번호가_기대하는_형식으로_출력되는지_테스트() {
        // Given
        List<Integer> generatedLottoNumbers = List.of(3, 15, 23, 42, 8, 19);

        // When
        lottoNumberPrinter.printThisLottoNumber(generatedLottoNumbers);

        // Then
        String expectedOutput = "[3, 15, 23, 42, 8, 19]" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}

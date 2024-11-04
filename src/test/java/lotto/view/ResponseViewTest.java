package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class ResponseViewTest {

	private final ResponseView responseView = ResponseView.getInstance();

	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}

	@DisplayName("구매한 로또를 출력한다.")
	@Test
	void printBoughtLottoTest() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		List<Lotto> lotto = List.of(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)),
			new Lotto(List.of(11, 12, 13, 14, 15, 16)),
			new Lotto(List.of(21, 22, 23, 24, 25, 26))
		);

		responseView.printBoughtLotto(lotto);
		String actualOutput = outputStream.toString();

		String expectedOutput = String.join(System.lineSeparator(),
			"3개를 구매했습니다.",
			"[1, 2, 3, 4, 5, 6]",
			"[11, 12, 13, 14, 15, 16]",
			"[21, 22, 23, 24, 25, 26]"
		) + System.lineSeparator();

		assertThat(actualOutput).isEqualTo(expectedOutput);
	}
}
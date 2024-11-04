package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.RequestMessage;

class RequestViewTest {

	private final RequestView requestView = RequestView.getInstance();

	@DisplayName("메시지를 포함한 입력이 정상적으로 처리된다.")
	@Test
	void inputWithMessageTest() {
		System.setIn(new ByteArrayInputStream(("1000").getBytes()));
		assertThatCode(() -> requestView.inputWithMessage(RequestMessage.LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage()))
			.doesNotThrowAnyException();
	}
}
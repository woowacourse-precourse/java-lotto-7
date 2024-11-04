package lotto;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PayingTest {

	@Test
	void testPaymentExceptionValidInput() {
		Paying paying = new Paying();

		// 올바른 입력값으로 예외가 발생하지 않는지 확인
		assertDoesNotThrow(() -> paying.paymentExcception("3000"));
		assertDoesNotThrow(() -> paying.paymentExcception("10000"));
	}

	@Test
	void testPaymentExceptionInvalidInput() {
		Paying paying = new Paying();

		// 숫자가 아닌 값 입력 시 예외 발생 확인
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> paying.paymentExcception("abc"));
		assertEquals("[ERROR] : 숫자만 입력해 주세요.", ex.getMessage());

		// 1000원 단위가 아닌 값 입력 시 예외 발생 확인
		ex = assertThrows(IllegalArgumentException.class, () -> paying.paymentExcception("1500"));
		assertEquals("[ERROR] : 1000원 단위로 입력해주새요.", ex.getMessage());
	}
}
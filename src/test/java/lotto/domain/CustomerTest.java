package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domains.customer.Customer;
import lotto.domains.lotto.domain.Lotto;
import lotto.domains.lotto.domain.LottoPrizeNumbers;
import lotto.domains.lotto.domain.LottoTicket;
import lotto.domains.lotto.type.LottoPrize;

public class CustomerTest {
	@DisplayName("Customer 클래스가 올바르게 생성된다.")
	@Test
	void Customer_클래스가_올바르게_생성된다() {
		assertThat(Customer.from(3000)).isInstanceOf(Customer.class);
	}

	@DisplayName("올바른 로또 개수를 계산한다.")
	@Test
	void 올바른_로또_개수를_계산한다() {
		Customer customer = Customer.from(3000);
		assertThat(customer.calculateAmount()).isEqualTo(3);
	}

	@DisplayName("천원 미만의 금액을 입력하면 예외가 발생한다.")
	@Test
	void 천원_미만의_금액을_입력하면_예외가_발생한다() {
		assertThatIllegalArgumentException().isThrownBy(() -> Customer.from(999));
	}

	@DisplayName("몇개의 로또가 당첨되었는지 확인할 수 있다")
	@Test
	void 몇개의_로또가_당첨되었는지_확인할_수_있다() {
		Customer customer = Customer.from(1000);
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumbers = 7;
		List<Lotto> tickets = List.of(
			new Lotto(List.of(1, 2, 3, 8, 9, 10)),
			new Lotto(List.of(2, 4, 6, 1, 12, 13))
		);
		LottoTicket lottoTickets = new LottoTicket(tickets);
		LottoPrizeNumbers lottoPrizeNumbers = LottoPrizeNumbers.of(winningNumbers, bonusNumbers);

		List<Map<Integer, Boolean>> winningStatus = customer.checkWinningStatus(lottoTickets, lottoPrizeNumbers);

		assertThat(winningStatus.stream().anyMatch(status -> status.containsKey(3))).isTrue();
		assertThat(winningStatus.stream().anyMatch(status -> status.containsKey(4))).isTrue();
	}

	@DisplayName("수익률을 올바르게 계산할 수 있다.")
	@Test
	void 수익률을_올바르게_계산할_수_있다() {
		Customer customer = Customer.from(8000);

		Map<LottoPrize, Integer> lottoResults = new LinkedHashMap<>();
		lottoResults.put(LottoPrize.THREE, 1);

		customer.calculateProfit(lottoResults);

		String expectedOutput = "총 수익률은 62.5%입니다.";
		String profitFormat = customer.formattingForPrintProfit();

		assertThat(profitFormat).isEqualTo(expectedOutput);
	}
}

package lotto.domains.lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domains.lotto.type.LottoPrize;
import lotto.util.LottoNumberGenerator;

public class LottoTicketMachine {
	private final int amount;

	private LottoTicketMachine(int amount) {
		this.amount = amount;
	}

	public static LottoTicketMachine from(int amount) {
		return new LottoTicketMachine(amount);
	}

	public LottoTicket generateLottoTickets(){
		return IntStream.range(0, amount)
			.mapToObj(i -> new Lotto(LottoNumberGenerator.generateLottoNumbers()))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::new));
	}

	public List<Map<LottoPrize,Integer>> generateLottoResult(List<Map<Integer,Boolean>> winningStatus) {
		Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();

		List<Map<LottoPrize, Integer>> result = new ArrayList<>();
		result.add(prizeCountMap);
		return result;
	}


}

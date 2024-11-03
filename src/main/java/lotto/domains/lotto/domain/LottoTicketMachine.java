package lotto.domains.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domains.lotto.type.LottoPrize;
import lotto.util.LottoNumberGenerator;
import lotto.view.OutputInterface;

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

	public String registerLottoResult(Map<LottoPrize, Integer> winningStatus, List<Map<Integer, Boolean>> lottoResults) {
		lottoResults.forEach(lottoResult-> {
			for (Map.Entry<Integer, Boolean> matches : lottoResult.entrySet()) {
				int matchCount = matches.getKey();
				boolean hasBonusNumber = matches.getValue();
				updateWinningStatus(winningStatus, matchCount, hasBonusNumber);
			}
		});
		return formattingForPrintLottoResult(winningStatus);
	}

	private String formattingForPrintLottoResult(Map<LottoPrize, Integer> winningStatus){
		return String.format(OutputInterface.WINNING_STATISTICS.toString(),
			winningStatus.get(LottoPrize.THREE),
			winningStatus.get(LottoPrize.FOUR),
			winningStatus.get(LottoPrize.FIVE),
			winningStatus.get(LottoPrize.FIVE_HAS_BONUS),
			winningStatus.get(LottoPrize.SIX)
			);
	}

	private static void updateWinningStatus(Map<LottoPrize, Integer> winningStatus, int matchCount, boolean hasBonusNumber) {
		for (LottoPrize prize : LottoPrize.values()) {
			if (prize.getMatchCount() == matchCount && prize.getHasBonusNumber() == hasBonusNumber) {
				winningStatus.put(prize, winningStatus.getOrDefault(prize, 0) + 1);
			}
		}
	}

}

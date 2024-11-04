package lotto.view;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.PrizeStat;
import lotto.parser.Parser;
import lotto.parser.ParserImpl;
import lotto.prize.Prize;

import static lotto.constant.PrintMessage.*;

public class ApplicationViewImpl implements ApplicationView {
	private static final ApplicationView INSTANCE;
	private final Parser parser;
	
	static {
		INSTANCE = new ApplicationViewImpl(ParserImpl.getInstance());
	}
	
	private ApplicationViewImpl(final Parser parser) {
		this.parser = parser;
	}
	
	public static ApplicationView getInstance() {
		return INSTANCE;
	}

	@Override
	public BigInteger requestPurchaseAmount() {
		System.out.println(REQ_PURCHASE_AMOUNT);
		return parser.purchaseAmount(Console.readLine());
	}

	@Override
	public void printLottoNumbers(final List<Lotto> lottos) {
		System.out.println("\n" + lottos.size() + RES_PURCHASE_COUNT);
		lottos.stream().forEach(System.out::println);
	}

	@Override
	public List<Integer> requestWinningNumbers() {
		System.out.println(REQ_WINNING_NUMBER);
		return parser.winningNumbers(Console.readLine());
	}

	@Override
	public int requestBonusNumber(final List<Integer> winningNumbers) {
		System.out.println(REQ_BONUS_NUMBER);
		return parser.bonusNumber(Console.readLine(), winningNumbers);
	}

	@Override
	public void printWinningStatistics(final PrizeStat prizeStat, final BigDecimal earningsRate) {
		System.out.println(RES_WINNING_DETAILS);
		printWinningDetails(prizeStat.getPrizeCounts());
		System.out.println(RES_RATE + earningsRate + RES_PERCENT);
	}
	
	private void printWinningDetails(final Map<Prize, Long> prizeCounts) {
		Arrays.stream(Prize.values())
			.forEach(prize -> System.out.println(prize.toString() + prizeCounts.get(prize) + RES_COUNT));
	}
}

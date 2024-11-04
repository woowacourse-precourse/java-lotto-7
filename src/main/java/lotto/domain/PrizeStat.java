package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.constant.Digit.INITIAL_COUNT;

import lotto.prize.Prize;

public class PrizeStat {
	private static final PrizeStat INSTANCE = new PrizeStat();
	private final Map<Prize, Long> prizeCounts;
	
	private PrizeStat() {
		prizeCounts = Arrays.stream(Prize.values())
				.collect(Collectors.toMap(prize -> prize, prize -> INITIAL_COUNT));
	}
	
	public static PrizeStat getInstance() {
		return INSTANCE;
	}
	
	public Map<Prize, Long> getPrizeCounts() {
		return prizeCounts;
	}
}

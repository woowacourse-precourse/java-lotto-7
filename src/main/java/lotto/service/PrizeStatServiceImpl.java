package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.PrizeStat;
import lotto.domain.WinNum;
import lotto.prize.Prize;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.repository.PrizeStatRepository;
import lotto.repository.PrizeStatRepositoryImpl;
import lotto.repository.WinNumRepository;
import lotto.repository.WinNumRepositoryImpl;

import static lotto.constant.Digit.*;
import static lotto.prize.Prize.*;

public class PrizeStatServiceImpl implements PrizeStatService {
	private static final PrizeStatService INSTANCE;
	private final PrizeStatRepository prizeStatRepository;
	private final LottoRepository lottoRepository;
	private final WinNumRepository winNumRepository;
	
	static {
		INSTANCE = new PrizeStatServiceImpl(PrizeStatRepositoryImpl.getInstance(),
										    LottoRepositoryImpl.getInstance(),
										    WinNumRepositoryImpl.getInstance());
	}
	
	private PrizeStatServiceImpl(final PrizeStatRepository prizeStatRepository,
			   					 final LottoRepository lottoRepository,
			   					 final WinNumRepository winNumRepository) {
		this.prizeStatRepository = prizeStatRepository;
		this.lottoRepository = lottoRepository;
		this.winNumRepository = winNumRepository;
	}
	
	public static PrizeStatService getInstance() {
		return INSTANCE;
	}
	
	@Override
	// 당첨 통계 생성
	public void create() {
		PrizeStat prizeStat = PrizeStat.getInstance();
		evaluateAllLottos(prizeStat);
		prizeStatRepository.save(prizeStat);
	}
	
	@Override
	// 당첨 통계 얻기
	public PrizeStat get() {
		return prizeStatRepository.find();
	}
	
	@Override
	// 수익률 계산
	public BigDecimal calculateEarningsRate(final int lottoCount) {
		BigDecimal totalEarnings = calculateTotalEarnings();
		BigDecimal purchaseAmount = calculatePurchaseAmount(lottoCount);
		return calculateRoundedEarningsRate(totalEarnings, purchaseAmount);
	}
	
	// 모든 로또 평가
	private void evaluateAllLottos(final PrizeStat prizeStat) {
		lottoRepository.findAll().stream()
			.forEach(lotto -> evaluateOneLotto(lotto.getNumbers(), prizeStat));
	}
	
	// 하나의 로또 평가
	private void evaluateOneLotto(final List<Integer> lottoNumbers, final PrizeStat prizeStat) {
		WinNum winNum = winNumRepository.find();
		int count = countMatchingNumbers(lottoNumbers, winNum);
		boolean hasBonus = containsBonusNumber(lottoNumbers, winNum);
		updatePrizeCounts(count, hasBonus, prizeStat);
	}
	
	// 당첨 번호와 매칭되는 로또 번호 개수 계산
	private int countMatchingNumbers(final List<Integer> lottoNumbers, final WinNum winNum) {
		return (int) lottoNumbers.stream()
				.filter(winNum.getNumbers()::contains)
				.count();
	}
	
	// 로또 번호 중 보너스 넘버 해당 여부
	private boolean containsBonusNumber(final List<Integer> lottoNumbers, final WinNum winNum) {
		return lottoNumbers.stream()
				.anyMatch(number -> number == winNum.getBonusNumber());
	}
	
	// 당첨이라면 당첨 횟수 1 증가 후 저장
	private void updatePrizeCounts(final int count, final boolean hasBonus, final PrizeStat prizeStat) {
		Map<Prize, Long> prizeCounts = prizeStat.getPrizeCounts();
		
		Arrays.stream(Prize.values())
			  .filter(prize -> isWinningPrize(count, hasBonus, prize))
			  .findFirst()
			  .ifPresent(prize -> {
				  prizeCounts.put(prize, prizeCounts.get(prize) + 1);
			  });
	}
	
	// 당첨 여부
	private boolean isWinningPrize(final int count, final boolean hasBonus, final Prize prize) {
		if (count != prize.getCount()) {
			return false;
		}
		return (prize != SECOND && prize != THIRD) || hasBonus == prize.hasBonus();
	}
	
	// 총 수익 계산
	private BigDecimal calculateTotalEarnings() {
		Map<Prize, Long> prizeCounts = get().getPrizeCounts();
		long totalEranings = Arrays.stream(Prize.values())
			.mapToLong(prize -> prize.getAmount() * prizeCounts.get(prize))
			.sum();
		return BigDecimal.valueOf(totalEranings);
	}
	
	// 구매 금액을 BigDecimal로 계산
	private BigDecimal calculatePurchaseAmount(final int lottoCount) {
		return BigDecimal.valueOf(lottoCount).multiply(BigDecimal.valueOf(LOTTO_PRICE));
	}
	
	// 수익률을 BigDecimal로 계산하여 소수점 첫째 자리까지 반올림
	private BigDecimal calculateRoundedEarningsRate(final BigDecimal totalEarnings, final BigDecimal purchaseAmount) {
		return totalEarnings.divide(purchaseAmount, SCALE_CALC_TO_THREE, RoundingMode.HALF_UP)
				.multiply(BigDecimal.valueOf(100))
				.setScale(SCALE_ROUND_TO_ONE, RoundingMode.HALF_UP);
	}
}

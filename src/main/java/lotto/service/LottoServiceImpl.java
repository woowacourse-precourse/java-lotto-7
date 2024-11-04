package lotto.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;

import static lotto.constant.Digit.*;

public class LottoServiceImpl implements LottoService {
	private static final LottoService INSTANCE;
	private final LottoRepository lottoRepository;
	
	static {
		INSTANCE = new LottoServiceImpl(LottoRepositoryImpl.getInstance());;
	}

	private LottoServiceImpl(final LottoRepository lottoRepository) {
		this.lottoRepository = lottoRepository;
	}
	
	public static LottoService getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void createAll(final BigInteger purchaseAmount) {
		long purchaseCount = calculatePurchaseCount(purchaseAmount);
		lottoRepository.saveAll(getNewLottos(purchaseCount));
	}

	@Override
	public List<Lotto> getAll() {
		return lottoRepository.findAll();
	}
	
	private long calculatePurchaseCount(final BigInteger purchaseAmount) {
		return purchaseAmount.divide(BigInteger.valueOf(LOTTO_PRICE)).longValue();
	}
	
	private List<Lotto> getNewLottos(final long purchaseCount) {
		return LongStream.range(0, purchaseCount)
				.mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT)))
				.collect(Collectors.toList());
	}
}

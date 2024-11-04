package lotto.controller;

import lotto.view.ApplicationView;
import lotto.view.ApplicationViewImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PrizeStat;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.service.PrizeStatService;
import lotto.service.PrizeStatServiceImpl;
import lotto.service.WinNumService;
import lotto.service.WinNumServiceImpl;

public class ControllerImpl implements Controller {
	private static final Controller INSTANCE;
	private final ApplicationView applicationView;
	private final LottoService lottoService;
	private final WinNumService winNumService;
	private final PrizeStatService prizeStatService;
	
	static {
		INSTANCE = new ControllerImpl(ApplicationViewImpl.getInstance(),
									  LottoServiceImpl.getInstance(),
									  WinNumServiceImpl.getInstance(),
									  PrizeStatServiceImpl.getInstance());
	}
	
	private ControllerImpl(final ApplicationView applicationView,
						   final LottoService lottoService,
						   final WinNumService winNumService,
						   final PrizeStatService prizeStatService) {
		this.applicationView = applicationView;
		this.lottoService = lottoService;
		this.winNumService = winNumService;
		this.prizeStatService = prizeStatService;
	}
	
	public static Controller getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void run() {
		requestPurchaseAmount();
		requestWinningNumbers();
	}
	
	// 사용자에게 구입 금액 입력 요청
	private void requestPurchaseAmount() {
		BigInteger purchaseAmount = applicationView.requestPurchaseAmount();
		responseLottoNumbers(generateLottos(purchaseAmount));
	}
	
	private List<Lotto> generateLottos(final BigInteger purchaseAmount) {
		lottoService.createAll(purchaseAmount);
		return lottoService.getAll();
	}
	
	// 생성된 로또 번호 출력 응답
	private void responseLottoNumbers(final List<Lotto> lottos) {
		applicationView.printLottoNumbers(lottos);
	}
	
	// 사용자에게 당첨 번호와 보너스 번호 입력 요청
	private void requestWinningNumbers() {
		List<Integer> winningNumbers = applicationView.requestWinningNumbers();
		int bonusNumber = applicationView.requestBonusNumber(winningNumbers);
		createWinningStatistics(winningNumbers, bonusNumber);
	}
	
	// 당첨 번호와 보너스 번호를 기반으로 통계 생성
	private void createWinningStatistics(final List<Integer> winningNumbers, final int bonusNumber) {
		winNumService.create(winningNumbers, bonusNumber);
		prizeStatService.create();
		responseWinningDetails();
	}
	
	// 생성된 당첨 통계 출력 응답
	private void responseWinningDetails() {
		BigDecimal earningsRate = prizeStatService.calculateEarningsRate(lottoService.getAll().size());
		applicationView.printWinningStatistics(getPrizeStat(), earningsRate);
	}
	
	private PrizeStat getPrizeStat() {
		return prizeStatService.get();
	}
}

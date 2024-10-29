package lotto;

import lotto.io.ErrorLogger;
import lotto.io.LottoRequestReader;
import lotto.io.LottoResponseWriter;
import lotto.dto.WinningLotto;

import java.util.List;
import java.util.Map;

public class LottoManager {

    private final LottoRequestReader lottoRequestReader;
    private final LottoResponseWriter lottoResponseWriter;
    private final ErrorLogger errorLogger;
    private final LottoMachine lottoMachine;
    private final LottoPricePolicy lottoPricePolicy;

    public LottoManager(LottoRequestReader lottoRequestReader, LottoResponseWriter lottoResponseWriter, ErrorLogger errorLogger, LottoMachine lottoMachine, LottoPricePolicy lottoPricePolicy) {
        this.lottoRequestReader = lottoRequestReader;
        this.lottoResponseWriter = lottoResponseWriter;
        this.errorLogger = errorLogger;
        this.lottoMachine = lottoMachine;
        this.lottoPricePolicy = lottoPricePolicy;
    }

    public void run() {
        int lottoPrice = lottoPricePolicy.getPrice();

        int purchaseMoney = getPurchaseMoney(lottoPrice);
        int buyCount = purchaseMoney / lottoPricePolicy.getPrice();

        for (int i = 0; i < buyCount; i++) {
            lottoMachine.buyLotto();
        }

        List<Lotto> buyingLottos = lottoMachine.getBuyingLottos();
        lottoResponseWriter.responseLottoPurchase(buyingLottos);

        WinningLotto winningLotto = getWinningLotto();

        Map<LottoPrize, Integer> lottoPrizeResult = lottoMachine.calculatePrize(winningLotto);

        lottoResponseWriter.responseLottoPrize(purchaseMoney, lottoPrizeResult);
    }

    private int getPurchaseMoney(int lottoPrice) {
        try {
            int money = lottoRequestReader.getPurchaseMoney();
            validateMoney(money, lottoPrice);
            return money;
        } catch (IllegalArgumentException e) {
            errorLogger.logError(e.getMessage());
            return getPurchaseMoney(lottoPrice);
        }
    }

    private void validateMoney(int money, int lottoPrice) {
        if (money < lottoPrice) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (money % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            List<Integer> winningLottoNumbers = lottoRequestReader.getLottoNumbers();
            int bonusNumber = lottoRequestReader.getBonusNumber();
            validateWinningLotto(winningLottoNumbers, bonusNumber);

            Lotto lotto = new Lotto(winningLottoNumbers);
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            errorLogger.logError(e.getMessage());
            return getWinningLotto();
        }
    }

    private void validateWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        if (winningLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (winningLottoNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (winningLottoNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
    }
}

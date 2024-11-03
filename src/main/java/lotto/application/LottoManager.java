package lotto.application;

import lotto.Lotto;
import lotto.LottoPricePolicy;
import lotto.LottoPrize;
import lotto.dto.LottoResult;
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

        int purchaseMoney = getPurchaseMoney(lottoPrice); // 로또 가격에 맞게, 유효한 구매 금액 입력 받음
        buyLotto(purchaseMoney / lottoPrice); // 금액에 맞게 로또 구입 후, 결과 출력

        WinningLotto winningLotto = getWinningLotto(); // 유효한 당첨 번호 입력 받음

        responseLottoResult(winningLotto, purchaseMoney); // 당첨 번호에 따른, 결과 집계 및 출력
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

    private void buyLotto(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            lottoMachine.buyLotto();
        }

        List<Lotto> buyingLottos = lottoMachine.getBuyingLottos();
        lottoResponseWriter.responseLottoPurchase(buyingLottos);
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
        validateLottoNumbers(winningLottoNumbers);
        validateBonusNumber(winningLottoNumbers, bonusNumber);
    }

    private void validateLottoNumbers(List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (winningLottoNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (winningLottoNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    private void validateBonusNumber(List<Integer> winningLottoNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }


    private void responseLottoResult(WinningLotto winningLotto, int purchaseMoney) {
        Map<LottoPrize, Integer> lottoPrizeResult = lottoMachine.calculatePrize(winningLotto);

        LottoResult lottoResult = new LottoResult(lottoPrizeResult, purchaseMoney);

        lottoResponseWriter.responseLottoPrize(lottoResult);
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final int purchaseAmount;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private List<Integer> lottoWinningNumbers = new ArrayList<>();
    private int lottoBonusNumber;
    private List<LottoRank> lottoRanks = new ArrayList<>();


    LottoController(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        createLotto();
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        if(!purchaseAmount.matches("\\d+") || Integer.parseInt(purchaseAmount)%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 숫자로 입력해야 합니다.");
        }
    }

    private void createLotto() {
        for(int i=0; i< purchaseAmount/1000; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            purchasedLottos.add(lotto);
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void parseLottoWinningNumbers(String[] inputLottoWinningNumbers) {
        for(String LottoWinningNumber : inputLottoWinningNumbers) {
            LottoWinningNumber = LottoWinningNumber.strip();
            validateParseLottoWinningNumber(LottoWinningNumber);
            lottoWinningNumbers.add(Integer.parseInt(LottoWinningNumber.strip()));
        }
        validateParseLottoWinningNumbers();
    }

    private void validateParseLottoWinningNumber(String lottoWinningNumber) {
        if(!lottoWinningNumber.matches("\\d+") || Integer.parseInt(lottoWinningNumber) > 45 || lottoWinningNumbers.contains(Integer.parseInt(lottoWinningNumber))) {
            lottoWinningNumbers.clear();
            throw new IllegalArgumentException("[ERROR] 로또 번호들은 1부터 45 사이의 서로 중복되지 않는 숫자여야 합니다.");
        }
    }

    private void validateParseLottoWinningNumbers() {
        if(lottoWinningNumbers.size()!=6) {
            lottoWinningNumbers.clear();
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    public void setLottoBonusNumber(String lottoBonusNumber) {
        validateBonusNumber(lottoBonusNumber);
        this.lottoBonusNumber = Integer.parseInt(lottoBonusNumber);
    }

    private void validateBonusNumber(String lottoBonusNumber) {
        if(!lottoBonusNumber.matches("\\d+") || Integer.parseInt(lottoBonusNumber) > 45 || lottoWinningNumbers.contains(Integer.parseInt(lottoBonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void checkWinning() {
        for(Lotto lotto : purchasedLottos) {
            int matchCount = countWinningNumbers(lotto);
            boolean bonusMatched = checkBonusNumber(lotto);
            LottoRank.setLottoRank(matchCount, bonusMatched);
        }
    }

    private int countWinningNumbers(Lotto lotto) {
        int matchCount = 0;
        for(int number : lotto.getNumbers()) {
            if(lottoWinningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean checkBonusNumber(Lotto lotto) {
        for(int number : lotto.getNumbers()) {
            if(number == lottoBonusNumber) {
                return true;
            }
        }
        return false;
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (LottoRank lottoRank : LottoRank.VALUES) {
            totalPrize += lottoRank.getPrizeAmount() * lottoRank.getCount();
        }
        return totalPrize;
    }

    public double calculateProfitRate(int totalPrize) {
        double profitRate = (totalPrize * 100.0) / purchaseAmount;
        return Math.round(profitRate * 100) / 100.0;
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoView lottoView;
    private int purchaseAmount;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private List<Integer> lottoWinningNumbers = new ArrayList<>();
    private int lottoBonusNumber;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        inputPurchaseAmount();
        createLottos();
        parseWinningNumbers();
        setBonusNumber();
        checkWinning();
        printResults();
        LottoRank.init();
    }

    private void inputPurchaseAmount() {
        while(true) {
            try {
                purchaseAmount = lottoView.purchaseAmountInput();
                Validate.isValidPurchaseAmount(Integer.toString(purchaseAmount));
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createLottos() {
        for (int i = 0; i < purchaseAmount / 1000; i++) {
            purchasedLottos.add(new Lotto(generateRandomLotto()));
        }
        lottoView.printPurchasedLottos(purchasedLottos);
    }

    private List<Integer> generateRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void parseWinningNumbers() {
        while(true) {
            try {
                lottoWinningNumbers = lottoView.lottoWinningNumbersInput();
                Validate.isValidWinningNumbers(lottoWinningNumbers);
                Validate.isValidWinningNumber(lottoWinningNumbers);
                break;
            } catch (IllegalArgumentException e){
                lottoWinningNumbers.clear();
                System.out.println(e.getMessage());
            }
        }
    }

    private void setBonusNumber() {
        while(true) {
            try{
                lottoBonusNumber = lottoView.lottoBonusInput();
                Validate.isValidBonusNumber(lottoBonusNumber, lottoWinningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkWinning() {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(lottoWinningNumbers::contains).count();
            boolean bonusMatched = lotto.getNumbers().contains(lottoBonusNumber);
            LottoRank.setLottoRank(matchCount, bonusMatched);
        }
    }

    private void printResults() {
        lottoView.printLottoRanksInfo();
        int totalPrize = calculateTotalPrize();
        lottoView.printLottoPrizeInfo(totalPrize, calculateProfitRate(totalPrize));
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (LottoRank lottoRank : LottoRank.valuesList()) {
            totalPrize += lottoRank.getPrizeAmount() * lottoRank.getCount();
        }
        return totalPrize;
    }

    private double calculateProfitRate(int totalPrize) {
        double profitRate = (totalPrize * 100.0) / purchaseAmount;
        return Math.round(profitRate * 100) / 100.0;
    }
}

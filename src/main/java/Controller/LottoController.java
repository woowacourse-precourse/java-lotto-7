package Controller;

import Model.BonusNumber;
import Model.Constant.Constants;
import Model.Enum.Prize;
import Model.Enum.Ranking;
import Model.Lotto;
import Model.LottoPurchase;
import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private Integer lottoAmount;
    private List<Lotto> myLottoNumbers;
    private Lotto winningLottoNumbers;
    private BonusNumber winningBonusNumber;

    public LottoController() {}

    public LottoController(Integer lottoAmount,
                           List<Lotto> myLottoNumbers,
                           Lotto winningLottoNumbers,
                           BonusNumber winningBonusNumber) {
        this.lottoAmount = lottoAmount;
        this.myLottoNumbers = myLottoNumbers;
        this.winningLottoNumbers = winningLottoNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public void playLottoGame() {
        buyMyLotto();
        assignLotto();
        showGameResult();
    }

    public void buyMyLotto() {
        assignPurchaseAmount();
        publishMyLotto();
        OutputView.PurchasedLottoCount(myLottoNumbers);
    }

    public void assignLotto() {
        assignLottoNumbers();
        assignBonusNumber();
    }

    public void showGameResult() {
        List<Integer> matchingCounts = calculateMatchingNumbers();
        double rateOfReturn = calculateRateOfReturn(matchingCounts);

        OutputView.printWinnerDetails(matchingCounts);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    public void assignPurchaseAmount() {
        boolean validInput = false;
        while(!validInput) {
            try {
                int inputPurchaseAmount = InputView.getPurchaseAmount();
                LottoPurchase purchaseAmount = new LottoPurchase(inputPurchaseAmount);
                lottoAmount = purchaseAmount.get() / Constants.DIVISOR;
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void publishMyLotto() {
        myLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    Constants.MIN_NUM, Constants.MAX_NUM, Constants.NUM_COUNT);
            myLottoNumbers.add(new Lotto(numbers));
        }
    }

    public void assignLottoNumbers() {
        boolean validInput = false;
        while (!validInput) {
            try {
                List<Integer> inputLotto = InputView.getLotto();
                winningLottoNumbers = new Lotto(inputLotto);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void assignBonusNumber() {
        boolean validInput = false;
        while (!validInput) {
            try {
                int inputBonusNumber = InputView.getBonusNumber();
                winningBonusNumber = new BonusNumber(inputBonusNumber);
                winningBonusNumber.validateAlreadyExist(winningLottoNumbers);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> calculateMatchingNumbers() {
        List<Integer> matchingCounts = new ArrayList<>(Collections.nCopies(Constants.RANK_COUNT, 0));
        for (Lotto myLotto : myLottoNumbers) {
            int matchingCount = myLotto.howManySameNumbers(winningLottoNumbers);
            if (matchingCount < Constants.MIN_RANK) continue;
            int index = findIndexWithValue(matchingCount, myLotto);
            matchingCounts.set(index, matchingCounts.get(index) + 1);
        }
        return matchingCounts;
    }

    public int findIndexWithValue(int number, Lotto lotto) {
        List<Ranking> ranks = List.of(Ranking.FIFTH_RANK, Ranking.FOURTH_RANK,
                Ranking.THIRD_RANK, Ranking.SECOND_RANK, Ranking.FIRST_RANK);
        int pos = 0;
        for (int i = 0; i < Constants.RANK_COUNT; i++) {
            if (number == ranks.get(i).get()) {
                pos = i;
                break;
            }
        }
        if (number == Ranking.THIRD_RANK.get() && lotto.isContains(winningBonusNumber)) {
            pos += 1;
        }
        return pos;
    }

    public double calculateRateOfReturn(List<Integer> matchingCounts) {
        long prize = calculatePrize(matchingCounts);
        return ((double) prize / (lottoAmount * Constants.DIVISOR)) * Constants.PERCENT;
    }

    public long calculatePrize(List<Integer> matchingCounts) {
        long lottoReward = 0;
        List<Prize> rewards = List.of(
                Prize.FIFTH_PRIZE,
                Prize.FOURTH_PRIZE,
                Prize.THIRD_PRIZE,
                Prize.SECOND_PRIZE,
                Prize.FIRST_PRIZE
        );
        for (int i = 0; i < Constants.RANK_COUNT; i++) {
            lottoReward += matchingCounts.get(i) * rewards.get(i).get();
        }
        return lottoReward;
    }
}

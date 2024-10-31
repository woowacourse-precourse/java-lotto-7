package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.common.LottoConstant;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.LottoPlace.FIFTH_PLACE;
import static lotto.common.LottoPlace.FIRST_PLACE;
import static lotto.common.LottoPlace.FOURTH_PLACE;
import static lotto.common.LottoPlace.SECOND_PLACE;
import static lotto.common.LottoPlace.THIRD_PLACE;

public class LottoService {
    private List<Integer> winningNumbers;
    private Integer bonusWinningNumber;

    private List<Lotto> lottos;
    private List<Integer> winningCount;
    private Integer money;
    private Integer prizeSum;

    public LottoService() {
        this.winningCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        this.lottos = new ArrayList<>();
        this.money = 0;
        this.prizeSum = 0;
    }

    public void purchaseLottos(Integer money) {
        this.money += money;
        LottoOutputView.printPurchase(money);
        try {
            for (int i = 0; i < money / LottoConstant.LOTTO_PRICE; i++) {
                lottos.add(generateLotto());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Lotto generateLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                        LottoConstant.MIN_NUMBER, LottoConstant.MAX_NUMBER, LottoConstant.NUMBERS_SIZE)
                .stream()
                .sorted()
                .toList());
        return lotto;
    }

    public float calculateReturnRate() {
        return ((float) prizeSum / (float) money) * 100;
    }

    public void checkLottos() {
        this.winningCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            checkLotto(lotto);
        }
    }

    private void checkLotto(Lotto lotto) {
        if (checkFirstPlace(lotto)) {
            return;
        }
        if (checkSecondPlace(lotto)) {
            return;
        }
        if (checkThirdPlace(lotto)) {
            return;
        }
        if (checkFourthPlace(lotto)) {
            return;
        }
        checkFifthPlace(lotto);
    }

    private boolean checkFirstPlace(Lotto lotto) {
        if (getEqualCount(lotto) == FIRST_PLACE.getEqualCount()) {
            winningCount.set(0, winningCount.get(0) + 1);
            prizeSum += FIRST_PLACE.getPrize();
            return true;
        }
        return false;
    }

    private boolean checkSecondPlace(Lotto lotto) {
        if (getEqualCount(lotto) == SECOND_PLACE.getEqualCount()
                && lotto.getNumbers().contains(bonusWinningNumber)) {
            winningCount.set(1, winningCount.get(1) + 1);
            prizeSum += SECOND_PLACE.getPrize();
            return true;
        }
        return false;
    }

    private boolean checkThirdPlace(Lotto lotto) {
        if (getEqualCount(lotto) == THIRD_PLACE.getEqualCount()) {
            winningCount.set(2, winningCount.get(2) + 1);
            prizeSum += THIRD_PLACE.getPrize();
            return true;
        }
        return false;
    }

    private boolean checkFourthPlace(Lotto lotto) {
        if (getEqualCount(lotto) == FOURTH_PLACE.getEqualCount()) {
            winningCount.set(3, winningCount.get(3) + 1);
            prizeSum += FOURTH_PLACE.getPrize();
            return true;
        }
        return false;
    }

    private boolean checkFifthPlace(Lotto lotto) {
        if (getEqualCount(lotto) == FIFTH_PLACE.getEqualCount()) {
            winningCount.set(4, winningCount.get(4) + 1);
            prizeSum += FIFTH_PLACE.getPrize();
            return true;
        }
        return false;
    }

    private int getEqualCount(Lotto lotto) {
        int count = 0;
        for (int i : lotto.getNumbers()) {
            if (winningNumbers.contains(i)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusWinningNumber() {
        return bonusWinningNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningCount() {
        return winningCount;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusWinningNumber(Integer bonusWinningNumber) {
        this.bonusWinningNumber = bonusWinningNumber;
    }
}

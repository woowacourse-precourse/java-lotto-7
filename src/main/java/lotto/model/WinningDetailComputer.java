package lotto.model;

import java.util.List;

public class WinningDetailComputer {

    private final List<Lotto> userLottoList;
    private final PrizeLotto prizeLotto;
    private final WinningDetailList winningDetailList;

    public WinningDetailComputer(List<Lotto> userLottoList, PrizeLotto prizeLotto,
                                 WinningDetailList winningDetailList) {
        this.userLottoList = userLottoList;
        this.prizeLotto = prizeLotto;
        this.winningDetailList = winningDetailList;
    }

    public List<WinningPriceStore> getWinningDetailList() {
        return this.winningDetailList.getPriceStoreList();
    }

    public void computeLottoList() {
        for (Lotto lotto : userLottoList) {
            computeLotto(lotto);
        }
    }

    private void computeLotto(Lotto userLotto) {
        int numberMatchCount = 0;

        List<Integer> prizeNumbers = prizeLotto.getNumbers();
        //PrizeLotto에 대해 몇 개 맞앗나 확인
        for (int targetNumber : prizeNumbers) {
            for (int userNumber : userLotto.getNumbers()) {
                if (targetNumber == userNumber) {
                    numberMatchCount++;
                }
            }
        }
        //PrizeLotto의 보너스 숫자가 맞았나 확인
        boolean isBonus = false;
        for (int userNumber : userLotto.getNumbers()) {
            if (prizeLotto.getBonusNumber() == userNumber) {
                if (numberMatchCount == 5) {
                    isBonus = true;
                }
                if (numberMatchCount < 5) {
                    numberMatchCount++;
                }
            }
        }

        if (numberMatchCount >= 3) {  //당첨!!
            this.winningDetailList.addSuccessLotto(numberMatchCount, isBonus);
        }
    }

    public long getReturnPercent(double money) {
        double totalPrice = 0;
        for (WinningPriceStore store : getWinningDetailList()) {
            totalPrice += store.getTotalPrice();
        }

        long returnPercent = Math.round(((double) totalPrice / money) * 100.0);
        return returnPercent;
    }
}

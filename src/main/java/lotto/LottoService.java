package lotto;

public class LottoService {

    public int calCulateLottoAmount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public int calculateRateOfReturnMoney(int purchaseAmount, int totalWinningMoney) {
        return totalWinningMoney / purchaseAmount * 100;
    }


}

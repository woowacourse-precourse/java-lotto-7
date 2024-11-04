package lotto;

public class CalculateLottoAmount {
    public final int moneyAmount;
    public final int lottoAmount;

    public CalculateLottoAmount(int moneyAmount) {
        if (moneyAmount < 1000 || moneyAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 작성해야 합니다.");
        }
        this.moneyAmount = moneyAmount;
        this.lottoAmount = moneyAmount / 1000;
    }

    public int getLottoAmount(){
        return lottoAmount;
    }

    public int getMoneyAmount(){
        return moneyAmount;
    }
}

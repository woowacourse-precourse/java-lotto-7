package lotto;

public class CalculateLottoAmount {
    public int moneyAmount;
    public int lottoAmount;

    public CalculateLottoAmount(int lottoAmount, int moneyAmount) {
        this.lottoAmount = lottoAmount;
        this.moneyAmount = moneyAmount;

        if (moneyAmount % 1000 != 0 ) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 작성해야합니다.");
        }

        this.lottoAmount = moneyAmount / 100;
    }
    public int getLottoAmount(){
        return lottoAmount;
    }
}

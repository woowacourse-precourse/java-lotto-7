package lotto.Domain;

public class LottoResult {
    private int firstPrize;
    private int secondPrize;
    private int thirdPrize;
    private int fourthPrize;
    private int fifthPrize;

    public LottoResult() {
        this.firstPrize = 0;
        this.secondPrize = 0;
        this.thirdPrize = 0;
        this.fourthPrize = 0;
        this.fifthPrize = 0;
    }

    public void addFirstPrize() {
        this.firstPrize++;
    }

    public void addSecondPrize() {
        this.secondPrize++;
    }

    public void addThirdPrize() {
        this.thirdPrize++;
    }

    public void addFourthPrize() {
        this.fourthPrize++;
    }

    public void addFifthPrize() {
        this.fifthPrize++;
    }

    public int getFirstPrize() {
        return firstPrize;
    }

    public int getSecondPrize() {
        return secondPrize;
    }

    public int getThirdPrize() {
        return thirdPrize;
    }

    public int getFourthPrize() {
        return fourthPrize;
    }

    public int getFifthPrize() {
        return fifthPrize;
    }

}

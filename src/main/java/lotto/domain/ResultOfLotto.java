package lotto.domain;

public class ResultOfLotto {
    private int numberOfMatching;
    private boolean isBonusNumberCorrect;

    public ResultOfLotto(int numberOfMatching, boolean isBonusNumberCorrect) {
        this.numberOfMatching = numberOfMatching;
        this.isBonusNumberCorrect = isBonusNumberCorrect;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public void setNumberOfMatching(int numberOfMatching) {
        this.numberOfMatching = numberOfMatching;
    }

    public boolean isBonusNumberCorrect() {
        return isBonusNumberCorrect;
    }

    public void setBonusNumberCorrect(boolean bonusNumberCorrect) {
        isBonusNumberCorrect = bonusNumberCorrect;
    }
}

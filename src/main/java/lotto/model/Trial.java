package lotto.model;

public class Trial {

    private final int trial;

    public Trial(int money) {
        this.trial = money / 1000;
    }

    public int getTrial() {
        return trial;
    }
}

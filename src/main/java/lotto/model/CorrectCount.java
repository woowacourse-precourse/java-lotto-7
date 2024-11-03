package lotto.model;

public class CorrectCount {

    private int count;
    private boolean bonus;

    private CorrectCount(final int count) {
        this.count = count;
        this.bonus = false;
    }

    public static CorrectCount from(final int count) {
        return new CorrectCount(count);
    }

    public void updateBonus() {
        bonus = true;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonus() {
        return bonus;
    }
}

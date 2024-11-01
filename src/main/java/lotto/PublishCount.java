package lotto;

public class PublishCount {

    private int tryCount;

    private PublishCount(int initialCount) {
        this.tryCount = initialCount;
    }

    public static PublishCount from(int initialCount) {
        return new PublishCount(initialCount);
    }

    public int getTryCount() {
        return tryCount;
    }
}

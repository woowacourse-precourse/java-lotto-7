package lotto.domain;

public class PublishCount {

    private static PublishCount instance;
    private int publishCount;

    // private 생성자
    private PublishCount(int initialCount) {
        this.publishCount = initialCount;
    }

    public static PublishCount getInstance(int initialCount) {
        if (instance == null) {
            instance = new PublishCount(initialCount);
        }
        return instance;
    }

    public int getPublishCount() {
        return publishCount;
    }
}
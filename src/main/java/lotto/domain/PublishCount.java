package lotto.domain;

import static lotto.constant.ErrorCode.OVER_PUBLIST_COUNT;

import lotto.view.OutputView;

public class PublishCount {

    private static PublishCount instance;
    private int publishCount;

    private PublishCount(int initialCount) {
        validate(initialCount);
        this.publishCount = initialCount;
    }

    private void validate(int initialCount) {
        if (initialCount > 30) {
            OutputView.printError(OVER_PUBLIST_COUNT.getMessage());
        }
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
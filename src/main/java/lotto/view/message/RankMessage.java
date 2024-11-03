package lotto.view.message;

import java.util.Arrays;

public enum RankMessage {
    MESSAGE_FIRST(1, "6개 일치 (2,000,000,000원) - %d개\n"),
    MESSAGE_SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    MESSAGE_THIRD(3, "5개 일치 (1,500,000원) - %d개\n"),
    MESSAGE_FOURTH(4, "4개 일치 (50,000원) - %d개\n"),
    MESSAGE_FIFTH(5, "3개 일치 (5,000원) - %d개\n");

    private final int rank;
    private final String message;

    RankMessage(int rank, String message) {
        this.rank = rank;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public String getMessage() {
        return message;
    }

    public static RankMessage findByRank(int rank) {
        return Arrays.stream(values())
                .filter(v -> v.getRank() == rank)
                .findAny()
                .orElse(null);
    }
}

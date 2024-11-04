package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import lotto.constant.ExceptionMessage;
import lotto.constant.Rank;

public enum OutputMessage {
    INPUT_MONEY("구입금액을 입력해 주세요.%n"),
    BUY_LOTTO_TICKETS("%n%d개를 구매했습니다.%n"),
    LOTTO_NUMBERS("[%s]%n"),
    INPUT_WINNING_NUMBERS("%n당첨 번호를 입력해 주세요.%n"),
    INPUT_BONUS_NUMBER("%n보너스 번호를 입력해 주세요.%n"),
    INIT_RESULT("%n당첨 통계%n---%n"),
    RANK_RESULT("%d개 일치 (%s원) - %d개%n"),
    RANK_RESULT_SECOND("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n"),
    RETURN_RESULT("총 수익률은 %.1f%%입니다."),
    EXCEPTION("%n[ERROR] %s%n%n"),
    ;

    private static final String DELIMITER = ", ";
    private static final String MONEY_PATTERN = "###,###";

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(List<Integer> lottoNumbers) {
        if (equals(LOTTO_NUMBERS)) {
            return String.format(message,
                lottoNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELIMITER))
            );
        }
        throw new IllegalStateException(ExceptionMessage.BAD_STATE_REQUEST.getMessage());
    }

    public String getMessage(Rank rank, int rankCount) {
        if (equals(RANK_RESULT)) {
            return String.format(
                getRankMessage(rank),
                rank.getMatchCount(),
                new DecimalFormat(MONEY_PATTERN).format(rank.getPrice()),
                rankCount
            );
        }
        throw new IllegalStateException(ExceptionMessage.BAD_STATE_REQUEST.getMessage());
    }

    private String getRankMessage(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return RANK_RESULT_SECOND.message;
        }
        return RANK_RESULT.message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}

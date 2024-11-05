package lotto.io;

import static lotto.constants.NumberConstants.DIVIDER_REPEAT_COUNT;
import static lotto.constants.OutputMessages.TOTAL_RATE_OF_RETURN_LABEL;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.constants.OutputMessages;
import lotto.constants.StringConstants;
import lotto.domain.Rank;
import lotto.dto.WinningResult;

public class WinningResultParser {

    public String parseWinningResult(WinningResult winningResult) {
        StringBuilder sb = new StringBuilder();

        appendWinningStatistics(sb);
        appendResult(sb, winningResult.getResult());

        double rateOfReturn = winningResult.getRateOfReturn();
        appendRateOfReturn(sb, parseRateOfReturn(rateOfReturn));

        return sb.toString();
    }

    private void appendWinningStatistics(StringBuilder sb) {
        sb.append(StringConstants.NEW_LINE)
                .append(OutputMessages.WINNING_STATISTICS_LABEL)
                .append(StringConstants.NEW_LINE)
                .append(StringConstants.DASH.repeat(DIVIDER_REPEAT_COUNT))
                .append(StringConstants.NEW_LINE);
    }

    private void appendResult(StringBuilder sb, Map<Rank, Integer> result) {

        for (Rank rank : result.keySet()) {
            if (rank != Rank.NONE) {
                append(sb, result, rank);
            }
        }
    }

    private void append(StringBuilder sb, Map<Rank, Integer> result, Rank rank) {
        sb.append(rank.getScore()).append(OutputMessages.COUNT_UNIT)
                .append(" " + OutputMessages.MATCH_LABEL)
                .append(getBonusBallTextIfSecondRank(rank))
                .append(" " + StringConstants.OPEN_PARENTHESIS)
                .append(rank.getStringPrize())
                .append(OutputMessages.WON)
                .append(StringConstants.CLOSE_PARENTHESIS)
                .append(" " + StringConstants.DASH + " ")
                .append(result.get(rank))
                .append(OutputMessages.COUNT_UNIT)
                .append(StringConstants.NEW_LINE);
    }

    private String getBonusBallTextIfSecondRank(Rank rank) {
        if (rank == Rank.SECOND) {
            return StringConstants.COMMA + " " + OutputMessages.BONUS_BALL + " " + OutputMessages.MATCH_LABEL;
        }
        return "";
    }

    private String parseRateOfReturn(double rateOfReturn) {
        DecimalFormat df = new DecimalFormat("#,##0.0");
        return df.format(rateOfReturn);
    }

    private void appendRateOfReturn(StringBuilder sb, String rateOfReturn) {

        sb.append(TOTAL_RATE_OF_RETURN_LABEL)
                .append(rateOfReturn)
                .append(StringConstants.PERCENT)
                .append(OutputMessages.IS_SUFFIX)
                .append(StringConstants.ENDING_DOT);
    }
}

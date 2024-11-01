package lotto.format;

import lotto.domain.LottoRank;
import lotto.dto.LottoRankCountMessageDto;

import java.util.List;
import java.util.function.Predicate;

import static java.lang.String.join;
import static java.util.stream.Collectors.joining;
import static lotto.domain.LottoRank.*;
import static lotto.message.OutputMessage.*;

public class LottoRankMessageFormatter implements MessageFormatter<List<LottoRank>> {

    private static final List<LottoRank> FORMAT_ORDER = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    private static final String RANK_COUNT_DELIMITER = " - ";
    private static final String SPACE_DELIMITER = " ";

    @Override
    public String format(List<LottoRank> target) {
        return FORMAT_ORDER.stream()
                .map(rank -> toLottoRankCount(rank, target))
                .map(this::formatRankCountMessage)
                .collect(joining(NEW_LINE));
    }

    private LottoRankCountMessageDto toLottoRankCount(LottoRank rank, List<LottoRank> target) {
        return LottoRankCountMessageDto.of(rank, getCount(target, rank::equals));
    }

    private long getCount(List<LottoRank> target, Predicate<LottoRank> isEqualRank) {
        return target.stream().filter(isEqualRank).count();
    }

    private String formatRankCountMessage(LottoRankCountMessageDto lottoRankCountMessageDto) {
        String rankMessage = formatRankMessage(lottoRankCountMessageDto.rank());
        String countMessage = formatCountMessage(lottoRankCountMessageDto.count());

        return join(RANK_COUNT_DELIMITER, rankMessage, countMessage);
    }

    private static String formatCountMessage(long count) {
        return OUTPUT_LOTTO_RANK_COUNT.getFormatMessage(count);
    }

    private String formatRankMessage(LottoRank rank) {
        String matchCountMessage = formatMatchCountMessage(rank);
        String prizeMoneyMessage = formatPrizeMoneyMessage(rank);
        
        return join(SPACE_DELIMITER, matchCountMessage, prizeMoneyMessage);
    }

    private String formatPrizeMoneyMessage(LottoRank rank) {
        return OUTPUT_LOTTO_PRIZE_MONEY.getFormatMessage(rank.getPrizeMoney());
    }

    private String formatMatchCountMessage(LottoRank rank) {
        String message = OUTPUT_LOTTO_MATCH_COUNT.getFormatMessage(rank.getMatchCount());

        if (rank.isBonusNumber()) {
            return join(BASIC_DELIMITER, message, OUTPUT_LOTTO_MATCH_BONUS_NUMBER.getMessage());
        }

        return message;
    }
}

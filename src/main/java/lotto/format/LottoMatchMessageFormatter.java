package lotto.format;

import lotto.domain.LottoMatch;
import lotto.domain.LottoRank;

import java.util.List;

import static java.lang.String.join;
import static java.util.stream.Collectors.joining;
import static lotto.domain.LottoRank.*;
import static lotto.message.OutputMessage.*;
import static lotto.message.SymbolMessage.SYMBOL_BASIC_DELIMITER;
import static lotto.message.SymbolMessage.SYMBOL_NEW_LINE;

public class LottoMatchMessageFormatter implements MessageFormatter<LottoMatch> {

    private static final List<LottoRank> RANK_ORDER = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    private static final String RANK_COUNT_DELIMITER = " - ";
    private static final String SPACE_DELIMITER = " ";

    @Override
    public String format(LottoMatch lottoMatch) {
        return RANK_ORDER.stream()
                .map(lottoRank -> createRankCountMessage(lottoRank, lottoMatch))
                .collect(joining(SYMBOL_NEW_LINE.message()));
    }

    private String createRankCountMessage(LottoRank lottoRank, LottoMatch lottoMatch) {
        long count = lottoMatch.getRanks().stream()
                .filter(lottoRank::equals)
                .count();

        String rankMessage = formatRankMessage(lottoRank);
        String countMessage = OUTPUT_LOTTO_MATCH_COUNT.format(count);

        return join(RANK_COUNT_DELIMITER, rankMessage, countMessage);
    }

    private String formatRankMessage(LottoRank lottoRank) {
        String matchCountMessage = OUTPUT_LOTTO_RANK_MATCH_COUNT.format(lottoRank.getMatchCount());
        String prizeMoneyMessage = OUTPUT_LOTTO_RANK_PRIZE_MONEY.format(lottoRank.getPrizeMoney());

        if (lottoRank.isBonusNumber()) {
            matchCountMessage = join(SYMBOL_BASIC_DELIMITER.message(), matchCountMessage,
                    OUTPUT_LOTTO_RANK_IS_BONUS_NUMBER.message());
        }

        return join(SPACE_DELIMITER, matchCountMessage, prizeMoneyMessage);
    }
}

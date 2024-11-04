package lotto.controller;

import java.util.List;
import lotto.domain.tier.LottoTier;
import lotto.domain.tier.Tier;

public class LottoTierPolicy implements TierPolicy{
    public static Integer SIX_WINNING_MATCH_COUNT = 6;
    public static Integer FIVE_WINNING_MATCH_COUNT = 5;
    public static Integer FOUR_WINNING_MATCH_COUNT = 4;
    public static Integer THREE_WINNING_MATCH_COUNT = 3;
    public static Boolean TRUE_NEEDS_BONUS_NUMBER_MATCH = true;
    public static Boolean FALSE_NEEDS_BONUS_NUMBER_MATCH = false;
    public static Long SIX_MATCH_AMOUNT = 2_000_000_000L;
    public static Long FIVE_MATCH_WITH_BONUS_NUMBER_AMOUNT = 30_000_000L;
    public static Long FIVE_MATCH_AMOUNT = 1_500_000L;
    public static Long FOUR_MATCH_AMOUNT = 50_000L;
    public static Long THREE_MATCH_AMOUNT = 5_000L;


    @Override
    public List<Tier> initTiers() {
        return List.of(LottoTier.initWinningTier(SIX_WINNING_MATCH_COUNT,
                        FALSE_NEEDS_BONUS_NUMBER_MATCH, SIX_MATCH_AMOUNT)
                ,LottoTier.initWinningTier(FIVE_WINNING_MATCH_COUNT,
                        TRUE_NEEDS_BONUS_NUMBER_MATCH,FIVE_MATCH_WITH_BONUS_NUMBER_AMOUNT)
                ,LottoTier.initWinningTier(FIVE_WINNING_MATCH_COUNT,
                        FALSE_NEEDS_BONUS_NUMBER_MATCH,FIVE_MATCH_AMOUNT)
                ,LottoTier.initWinningTier(FOUR_WINNING_MATCH_COUNT,
                        FALSE_NEEDS_BONUS_NUMBER_MATCH,FOUR_MATCH_AMOUNT)
                ,LottoTier.initWinningTier(THREE_WINNING_MATCH_COUNT,
                        FALSE_NEEDS_BONUS_NUMBER_MATCH,THREE_MATCH_AMOUNT));
    }

}

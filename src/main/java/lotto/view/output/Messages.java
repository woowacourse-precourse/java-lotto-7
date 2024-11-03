package lotto.view.output;

import static lotto.model.lotto.lottoNumber.LotteryRule.LOTTERY_NUMBER_COUNT;

import java.util.List;
import lotto.model.lotto.winningResult.rank.Rank;

public class Messages {
    private static final String NUMBER_SEPERATOR = ", ";
    private static final String LOTTO_START_BRACKET = "[";
    private static final String LOTTO_END_BRACKET = "]";
    private static final String THOUSAND_SEPERATOR = ",";
    private static final int THOUSAND_SEPARATOR_INTERVAL = 3;


    public static final String ISSUED_LOTTO(List<Integer> lottoNumbers) {
        StringBuilder issuedLotto = new StringBuilder(LOTTO_START_BRACKET);
        for (int i = 0; i < LOTTERY_NUMBER_COUNT; i++) {
            issuedLotto.append(lottoNumbers.get(i));
            if (i == LOTTERY_NUMBER_COUNT - 1) {
                issuedLotto.append(LOTTO_END_BRACKET);
                break;
            }
            issuedLotto.append(NUMBER_SEPERATOR);
        }
        return issuedLotto.toString();
    }

    public static final String MATCHING_CONDITION(Rank rank) {
        StringBuilder matchingContidion = new StringBuilder(
                String.format("%d개 일치", rank.getMatchingAmount())
        );
        if (rank == Rank.SECOND) {
            matchingContidion.append(", 보너스 볼 일치");
        }
        return matchingContidion.toString();
    }

    public static final String PRICE(int priceInteger) {
        StringBuilder price = new StringBuilder(String.valueOf(priceInteger))
                .reverse();
        int insertIndex = THOUSAND_SEPARATOR_INTERVAL;
        while (insertIndex < price.length()) {
            price.insert(insertIndex, THOUSAND_SEPERATOR);
            insertIndex += (THOUSAND_SEPARATOR_INTERVAL + 1);
        }
        return price.reverse().toString();
    }
}

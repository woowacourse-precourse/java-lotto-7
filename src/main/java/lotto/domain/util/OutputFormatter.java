package lotto.domain.util;

import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class OutputFormatter {
    public static final Map<Rank, String> rankMessages = new HashMap<>();

    static {
        rankMessages.put(Rank.FIFTH, "3개 일치 (5,000원) - %d개");
        rankMessages.put(Rank.FOURTH, "4개 일치 (50,000원) - %d개");
        rankMessages.put(Rank.THIRD, "5개 일치 (1,500,000원) - %d개");
        rankMessages.put(Rank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개");
        rankMessages.put(Rank.FIRST, "6개 일치 (2,000,000,000원) - %d개");
    }
}

package lotto.system.utils;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeType { // 당첨 번호와 보너스 번호를 비교하여 당첨 결과를 반환하는 객체

    FIFTH_PRIZE(3,5_000,"3개 일치 (5,000원)"),

    FOURTH_PRIZE(4,50_000,"4개 일치 (50,000원)"),

    THIRD_PRIZE(5,1_500_000,"5개 일치 (1,500,000원)"),

    SECOND_PRIZE(6,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),

    FIRST_PRIZE(7,2_000_000_000,"6개 일치 (2,000,000,000원)");

    private static final Map<Integer, PrizeType> codeToPrizeTypeMap =
            Stream.of(values()).collect(
                    Collectors.toMap(PrizeType::getCode, type -> type)
            );

    private final int code;
    private final int prizeMoney;
    private final String description;

    PrizeType(int code, int prizeMoney, String description) {
        this.code = code;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static PrizeType getTypeByCode(int code) {
        return codeToPrizeTypeMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
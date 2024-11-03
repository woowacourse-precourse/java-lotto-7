package lotto.controller.dto;

import lotto.domain.value.Standard;

public class PrizeResultDto implements Comparable<PrizeResultDto> {

    private Standard standard;
    private int count;

    public PrizeResultDto(Standard standard, int count) {
        this.standard = standard;
        this.count = count;
    }

    public Standard getStandard() {
        return standard;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(PrizeResultDto o) {
        return this.standard.getPrizeMoney() - o.standard.getPrizeMoney();
    }
}

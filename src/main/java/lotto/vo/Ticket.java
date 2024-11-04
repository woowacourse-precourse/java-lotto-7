package lotto.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final int WINNING_NUMBER_COUNT = 6;

    private final List<Integer> ticket;

    public Ticket() {
        this.ticket = pickRandom();
    }

    private List<Integer> pickRandom() {
        return Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, WINNING_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getTicket() {
        return ticket;
    }
}

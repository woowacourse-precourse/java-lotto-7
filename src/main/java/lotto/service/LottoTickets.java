package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.response.TicketResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoTickets {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public TicketResponse buyTicket(int number) {
        int count = calculateNumberOfTickets(number);
        List<List<Integer>> numbers = generateAllLottoNumbers(count);

        return TicketResponse.from(numbers);
    }

    private int calculateNumberOfTickets(int number) {
        return number / LOTTO_PRICE;
    }

    private List<Integer> generateLottoNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_SIZE));
    }

    private List<List<Integer>> generateAllLottoNumbers(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLottoNumbers())
                .collect(Collectors.toList());
    }
}

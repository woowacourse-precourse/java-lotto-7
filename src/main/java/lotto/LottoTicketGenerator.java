package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class LottoTicketGenerator {
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(generateUniqueNumbers()));
        }
        return tickets;
    }

    private List<Integer> generateUniqueNumbers() {
        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();

        while (numbers.size() < LOTTO_NUMBERS_COUNT) {
            int number = random.nextInt(45) + 1;
            numbers.add(number);
        }

        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        lottoNumbers.sort(Integer::compareTo);
        return lottoNumbers;
    }
}

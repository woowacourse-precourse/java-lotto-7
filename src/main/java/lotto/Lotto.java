package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private static Lotto generateRandomLotto() {
        Set<Integer> uniqueNumbers = new TreeSet<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return new Lotto(new ArrayList<>(uniqueNumbers));
    }

    public static List<Lotto> generateLottoTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / InputHandler.getTicketPrice();
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(Lotto.generateRandomLotto());
        }
        return tickets;
    }
}

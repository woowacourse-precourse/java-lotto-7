package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicketGenerator {
    public List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateLotto());
        }
        return tickets;
    }

    private Lotto generateLotto() {
        Set<Integer> numbersSet = new HashSet<>();
        while (numbersSet.size() < 6) {
            int number = (int) (Math.random() * 45) + 1;
            numbersSet.add(number);
        }
        List<Integer> numbers = new ArrayList<>(numbersSet);
        Collections.sort(numbers);

        // Lotto 인스턴스 생성 및 반환
        Lotto lotto = new Lotto(numbers);
        printLottoNumbers(numbers);  // Lotto의 numbers 필드에 직접 접근하지 않고 출력하는 메서드
        return lotto;
    }

    private void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}

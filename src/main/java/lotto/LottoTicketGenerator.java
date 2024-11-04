package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator {
    public List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateLotto());
        }
        return tickets;
    }


    private Lotto generateLotto() {
        // 리스트를 변경 가능하게 복사한 후 정렬 수행
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);

        // Lotto 인스턴스 생성 및 반환
        return new Lotto(numbers);
    }


    private void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBox {

    private final int buy;
    private final List<Lotto> lottoTickets = new ArrayList<>(); // 구입한 로또 티켓을 저장할 리스트

    // 구매 개수를 받아 로또 리켓 생성
    public LottoBox(int buy) {

        this.buy = buy; // 구입한 개수 저장

        for (int i=0; i<buy; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers(); // 로또 번호 생성
            Collections.sort(lottoNumbers); // 정렬
            lottoTickets.add(new Lotto(lottoNumbers)); // Lotto 객체로 생성하여 리스트에 추가
        }
    }

    // 랜덤으로 로또 생성
    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 로또 티켓 print
    public void Print() {

        System.out.println(String.valueOf(buy)+"개를 구매했습니다.");

        for (Lotto ticket : lottoTickets) {
            String result = ticket.getNumbers().stream()
                    .map(String::valueOf) // Integer를 String으로 변환
                    .collect(Collectors.joining(", ")); // Join

            System.out.println("["+result+"]"); // 출력: [1, 2, 3, 4, 5, 6]
        }
    }

    public List<Lotto> getLotto() {
        return lottoTickets;
    }
}

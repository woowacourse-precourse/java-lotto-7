package lotto.view;

import java.util.List;

public class LottoOutputView {

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoTicket(List<List<Integer>> lottoTicketNumbers) {
        lottoTicketNumbers.stream()
                .map(lotto -> lotto.toString()) // 각 로또 티켓 번호를 문자열로 변환
                .forEach(System.out::println); // 각 로또 티켓 번호를 한 줄씩 출력
    }
}

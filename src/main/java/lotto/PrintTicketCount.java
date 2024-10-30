package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintTicketCount {
    private final int lottoTicketCount;

    public PrintTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public void printCount() {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public void repeatPrintNumber() {
        for (int i = 0; i < lottoTicketCount; i++) {
            makeLottoNumber();
        }
    }

    private void makeLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }
}

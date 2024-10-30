package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintTicketCount {
    private final int lottoTicketCount;
    private final List<List<Integer>> userTicketNumbers;

    public PrintTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
        this.userTicketNumbers = new ArrayList<>();
    }

    public List<List<Integer>> getTicketNumbers() {
        return userTicketNumbers;
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
        userTicketNumbers.add(lottoNumbers);
        System.out.println(lottoNumbers);
    }
}

package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Lotto> createLotto(int numberOfTickets) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public List<Prize> countMatches(List<Lotto> lottos, WinningNumbers winningNumbers) {
        // 당첨 결과를 저장할 리스트
        List<Prize> prizes = new ArrayList<>();

        // 당첨 결과 계산
        for (Lotto lotto : lottos) {
            int matchCount = winningNumbers.matchLotto(lotto); // 맞춘 개수
            boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonusNumber()); // 보너스 번호 일치 여부

            Prize prize = Prize.getPrize(matchCount, bonusMatch); // 당첨 등수 결정
            if (prize != null) {
                prizes.add(prize); // 리스트에 추가
            }
        }

        return prizes; // 당첨 결과 리스트 반환
    }


}

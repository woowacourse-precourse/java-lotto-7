package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class LottoController {
    public void run() {
        // 로또 구입 금액 입력 받기
        int inputCash, lottoCount;
        while (true) {
            try {
                inputCash = LottoView.getInputCash();

                if (inputCash < 1000) {
                    throw new IllegalArgumentException("[ERROR] 1000원 이상으로 입력해주세요.");
                } else if (inputCash % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
                }

                lottoCount = inputCash / 1000;
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 로또 생성 과정
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        // 발행한 로또 수량 및 번호 출력
        LottoView.printLottos(lottoCount, lottos);

        // 당첨 번호 및 보너스 번호 입력 받기
        List<Integer> winningNumbers = null;
        while (true) {
            try {
                winningNumbers = LottoView.getWinningNumbers();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // 보너스 번호 입력 받기
        Integer bonusNumber;
        while (true) {
            try {
                bonusNumber = LottoView.getBonusNumber();

                Set<Integer> nonDuplicateNumbers = new HashSet<>(winningNumbers);
                nonDuplicateNumbers.add(bonusNumber);
                if (nonDuplicateNumbers.size() != 7) {
                    throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // 당첨 여부 확인

        // 등수 계산
        Map<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);
        int totalPrize = 0;

        // 각 등수의 개수를 0으로 초기화
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Set<Integer> matchedNumbers = new HashSet<>(winningNumbers);
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());

            boolean isBonusMatched = lottoNumbers.contains(bonusNumber);
            matchedNumbers.retainAll(lottoNumbers);

            int matchCount = matchedNumbers.size();
            LottoRank rank = LottoRank.calculateRank(matchCount, isBonusMatched);

            if (rank != null) {
                rankCount.put(rank, rankCount.get(rank) + 1);
                totalPrize += rank.getPrize();
            }
        }

        // 당첨 내역 출력
        LottoView.printLottoResult(rankCount);

        // 수익률 계산 및 출력
        LottoView.printReturnRate(totalPrize, inputCash);
    }
}

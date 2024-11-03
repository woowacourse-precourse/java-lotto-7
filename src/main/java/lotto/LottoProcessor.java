package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoProcessor {
    List<Lotto> lottos = new ArrayList<>();
    int[] rewardCounts = new int[LottoReward.values().length];
    Lotto winningNumbers;
    private int bonusNumber;
    private int money = 0;

    // 구매 금액만큼 로또 생성
    public void createLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> tempLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(tempLotto);
            lottos.add(new Lotto(tempLotto));
            System.out.println(tempLotto.toString());
        }
    }

    public void setWinningNumbers(String[] input) {
        // 당첨 번호를 입력받기
        List<Integer> tempWinningNumbers = new ArrayList<>();
        for (String inputNumber : input) {
            tempWinningNumbers.add(Integer.parseInt(inputNumber));
        }
        winningNumbers = new Lotto(tempWinningNumbers);
    }

    public void setBonusNumber(int number) {
        // 보너스 번호가 당첨 번호에 있는지 확인
        if (winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        bonusNumber = number;
    }

    public void matchLotto() {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            boolean matchBonus = false;
            int matchCount = countMatchNumber(numbers);
            if (numbers.contains(bonusNumber)) {
                matchBonus = true;
            }

            LottoReward reward = LottoReward.valueOf(matchCount, matchBonus);
            rewardCounts[reward.ordinal()]++;
            money += reward.getPrize();
        }
    }

    public int countMatchNumber(List<Integer> numbers) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double calculateReturnPrice(int purChaseAmount) {
        return Math.round((money / (double) purChaseAmount) * 1000) / 10.00;
    }

    public int[] getRewardCounts() {
        return rewardCounts;
    }
}

package lotto.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> splitLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            try {
                // trim()을 사용해 공백을 제거하고 숫자인 경우에만 추가
                if (!number.trim().isEmpty())
                    lottoNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호를 다시 확인해 주세요.");
            }
        }
        return lottoNumbers;
    }

    public static int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (lottoNumbers.contains(userNumber)) {
                count++;
            }
        }
        return count;
    }

    public static boolean calculateBonusMatch(int matchCount, int bonusNumber, List<Integer> userNumbers) {
        if (matchCount == 5) {
            return userNumbers.contains(bonusNumber);
        }
        return false;
    }

    public static int calculateProfit(int prize, int count) {
        return prize * count;
    }

    public static double calculateProfitRate(int profit, int money) {
        return (double) profit / money * 100;
    }
}

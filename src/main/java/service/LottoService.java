package service;


import domain.LottoResult;
import lotto.Lotto;

import java.util.List;

public class LottoService {

    public int[] getLotto(String input) {
        String[] list = input.split(",");
        int[] numbers = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            numbers[i] = Integer.parseInt(list[i]);
        }
        return numbers;
    }

    public int getResult(LottoResult result, Lotto lotto) {
        int count = 0;
        int[] target = result.getWinningNumbers();
        List<Integer> list = lotto.getNumbers();

        for (Integer num : list) {
            if (isEqual(target, num)) {
                count++;
            }
        }

        return count;
    }

    public boolean isEqual(int[] target, int num) {
        for (int t : target) {
            if (t == num) return true;
        }
        return false;
    }

    // 3-0 , 4-1 , 5-2, 6-3
    public void setResult(int equal, int[] result, boolean isBonus) {
        if (equal < 3) return;
        if (equal == 3) {
            result[0]++;
            return;
        }
        if (equal == 4) {
            result[1]++;
            return;
        }
        if (equal == 5 && !isBonus) {
            result[2]++;
            return;
        }
        if (equal == 5 && isBonus) {
            result[3]++;
            return;
        }
        if (equal == 6) {
            result[4]++;
        }
    }

    public boolean getBonus(int bonusNumber, Lotto lotto) {
        List<Integer> list = lotto.getNumbers();
        for (Integer num : list) {
            if (num == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public int getRatio(int[] result) {
        int[] reward = {5000, 50000, 1500000, 30000000, 2000000000};
        int sum = 0;
        for(int i=0; i<5; i++){
            sum += reward[i] * result[i];
        }
        return sum;
    }
}

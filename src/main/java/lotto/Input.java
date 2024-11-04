package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    public Lotto winner() {
        System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분):");
        String inputNo = Console.readLine();
        System.out.println(inputNo);

        List<Integer> winNo = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        String[] numbers = inputNo.split(",");

        for (String num : numbers) {
            int number = Integer.parseInt(num.trim());

            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다: " + number);
            }

            uniqueNumbers.add(number);
            winNo.add(number);
        }

        if (winNo.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        Lotto lotto = new Lotto(winNo);
        return lotto;
    }

    public int bonus(Lotto winNo) {
        System.out.println("보너스 번호를 입력해 주세요:");
        int bonusNo = Integer.parseInt(Console.readLine());
        System.out.println(bonusNo);

        if (bonusNo < 1 || bonusNo > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winNo.contains(bonusNo)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return bonusNo;
    }
}

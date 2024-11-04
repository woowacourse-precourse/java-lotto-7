package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public Lotto winner() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNo = Console.readLine();
        System.out.println(inputNo);

        List<Integer> winNo = new ArrayList<>();
        String[] numbers = inputNo.split(",");

        for (String num : numbers) {
            winNo.add(Integer.parseInt(num.trim()));
        }

        Lotto lotto = new Lotto(winNo);
        return lotto;
    }

    public int bonus() {
        System.out.println("당첨 번호를 입력해 주세요.");
        int bonusNo = Integer.parseInt(Console.readLine());
        System.out.println(bonusNo);

        return bonusNo;
    }
}

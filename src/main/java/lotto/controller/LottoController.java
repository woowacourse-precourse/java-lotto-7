package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoController {
    //Feat : 로또 발생기-구현을 취한 입력 구현
    //- 구입금액, 당첨번호, 보너스 번호 입력

    private final List<Lotto> lottos = new ArrayList<>();
    private int bonusNum;

    public void buyLottos() {
        System.out.println("구입 금액을 입력해 주세요: ");
        int amount = Integer.parseInt(Console.readLine());

        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6); // 랜덤 번호 생성
        lottos.add(new Lotto(numbers));

    }

    public List<Integer> inputLottoNumbers() {
        System.out.println("당첨 번호 6개를 입력해 주세요 (쉼표로 구분): ");
        String input = Console.readLine();
        String[] splitNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitNumbers) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요 (쉼표로 구분): ");
        String bonus = Console.readLine();
        bonusNum = Integer.parseInt(bonus);
    }

    public void displayLottos() {
        System.out.println("발행한 로또 번호:");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }


}

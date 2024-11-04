package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int inputPurchaseAmount = Integer.parseInt(Console.readLine());
        setAmount(inputPurchaseAmount);

        int lottoCount = inputPurchaseAmount / 1000;
        List<List<Integer>> AllRandomNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            AllRandomNumbers.add(randomNumbers);
        }
        for (int i = 0; i < AllRandomNumbers.size(); i++) {
            System.out.println(AllRandomNumbers.get(i));
        }

        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        String inputWinningNumber = Console.readLine();
        List<Integer> inputLotto = Arrays.stream(inputWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        Lotto lottoNumbers = new Lotto(inputLotto);

        System.out.println("보너스 번호를 입력해 주세요.");
        int inputBonusNumber = Integer.parseInt(Console.readLine());


        System.out.println("당첨 통계" + "\n" + "---");
        HashMap<LottoRank, Integer> lottoResults = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.put(rank, 0);
        }

        // TODO: 기능구현

    }

    public static void setAmount(int inputPurchaseAmount) {
        if (inputPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입가능합니다.");
        }
        System.out.println(("\n" + inputPurchaseAmount / 1000) + "개를 구매했습니다.");
    }


}

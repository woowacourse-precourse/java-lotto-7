package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoPurchasePrice = Integer.parseInt(validate(Console.readLine()));
        int lottoPurchaseQuantity = calculateLottoQuantity(lottoPurchasePrice);
        print(lottoPurchaseQuantity);
        List<Lotto> lottos = createLottos(lottoPurchaseQuantity);
        print(lottos);
        List<Integer> lottoWinningNumbers = createWinningLottoNumber(Console.readLine());
        int bonusNumber = Integer.parseInt(Console.readLine());

    }

    private static List<Integer> createWinningLottoNumber(String inputString) {
        return Arrays.stream(inputString.split(",")).map(Integer::parseInt).toList();
    }

    private static void print(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }

    private static List<Lotto> createLottos(int lottoPurchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseQuantity; i++) {
            List<Integer> lottoNumbers = createLottoNumbers();
            sort(lottoNumbers);
            Lotto lotto = createLotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void print(int lottoPurchaseQuantity) {
        System.out.println(lottoPurchaseQuantity + "개를 구매했습니다.");
    }

    public static int calculateLottoQuantity(int lottoPurchasePrice) {
        return lottoPurchasePrice / 1000;
    }

    public static String validate(String enterPrice) {
        return enterPrice;
    }
}

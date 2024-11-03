package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = inputLottoPurchaseAmount();
        int lottoCount = calculateLottoCount(purchasePrice);

        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottoPurchaseList = purchaseRandomLottoTickets(lottoCount);
        printLottoPurchaseList(lottoPurchaseList);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lottoNumbers = inputWinningLottoNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputBonusNumber(lottoNumbers);

    }

    public static int inputLottoPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchasePrice = Integer.parseInt(readLine());
            if (!validateCount(purchasePrice)) {
                throw new IllegalArgumentException();
            }
            return purchasePrice;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요. ");
            return inputLottoPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoPurchaseAmount();
        }
    }

    public static int calculateLottoCount(int price) {
        int count = 0;
        count = price / 1000;
        return count;
    }

    public static boolean validateCount(int price) {
        if (price == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1000원 입니다. 금액을 다시 입력해 주세요.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지지 않습니다. 금액을 다시 입력해 주세요.");
        }
        return true;
    }

    public static List<Lotto> purchaseRandomLottoTickets(int count) {
        List<Lotto> lottoPurchaseList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            lottoPurchaseList.add(lotto);
        }
        return lottoPurchaseList;
    }

    public static void printLottoPurchaseList(List<Lotto> LottoPurchaseList) {
        for (Lotto lotto : LottoPurchaseList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static Lotto inputWinningLottoNumbers() {
        try {
            String[] s = readLine().split(",");
            List<Integer> w = new ArrayList<>();
            for (String str : s) {
                w.add(Integer.parseInt(str));
            }
            Lotto lotto = new Lotto(w);
            return lotto;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return inputWinningLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoNumbers();
        }
    }

    public static int inputBonusNumber(Lotto lotto) {
        try {
            int bonusNumber = Integer.parseInt(readLine());
            isBonusNumber(bonusNumber);
            isDuplicatePresent(lotto, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return inputBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(lotto);
        }
    }

    public static void isBonusNumber(int input) {
        if (!(input > 0 && input <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 값을 입력해주세요.");
        }
    }

    public static void isDuplicatePresent(Lotto lotto, int input) {
        for (int n : lotto.getNumbers()) {
            if (n == input) {
                throw new IllegalArgumentException("[ERROR] 중복된 값입니다. 다시 입력해 주세요. ");
            }
        }
    }

}

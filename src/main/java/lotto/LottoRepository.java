package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private static final int lotto_Price = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();

    //실행 메서드 구현
    public void run() {
        try {
            int amount = getPurchaseAmount();
            purchaseLottos(amount);
            displayPurchasedLottos();

            Lotto winningLotto = getWinningLotto();
            int bonusNumber = getBonusNumber();
            LottoResult result = new LottoResult(purchasedLottos, winningLotto, bonusNumber);
            result.printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    //로또 구입 메서드 구현
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            if (amount % lotto_Price != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로 입력해 주세요.");
        }
    }

    //로또 구입 갯수 메서드 구현
    public void purchaseLottos(int amount) {
        int count = amount / lotto_Price;
        System.out.printf("%d개를 구매했습니다.\n", count);
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(Lotto.generateRandomNumbers());
        }
    }

    //당첨 번호 메서드 구현
    public Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseLottoNumbers(input);
    }
    //입력값 처리 메서드
    public Lotto parseLottoNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part.trim()));
        }
        return new Lotto(numbers);
    }

    //보너스 번호 입력 구현
    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }
    //구매한 로또 번호 출력
    public void displayPurchasedLottos() {
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}


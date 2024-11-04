package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSeller {
    private static final int lottoPrice = 1000;

    public void run() {
        int pay = readPay();
        List<Lotto> lottos = buyLottos(pay);
        LottoBonus lottoBonus = readLottoBonus(readWinnerLotto());
        Map<Place, Integer> winningResult = LottoInspector.checkLottos(lottoBonus, lottos);
        printLottoResult(winningResult);
        printSurplusRate(winningResult, pay);
    }

    private int readPay() {
        String input;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input = Console.readLine();
                validatePay(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    private void validatePay(String input) throws IllegalArgumentException {
        int pay;
        try {
            pay = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자여야 합니다.");
        }
        if (pay < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 양수여야 합니다.");
        }
        if (pay % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원을 단위로 입력해야 합니다.");
        }
    }

    private List<Lotto> buyLottos(int pay) {
        int lottoCount = pay / lottoPrice;
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = LottoRandomGenerator.generate(lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    private Lotto readWinnerLotto() {
        Lotto winner;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> numbers = parseWinnerLotto(Console.readLine());
                winner = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winner;
    }

    private List<Integer> parseWinnerLotto(String input) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String token : input.split(",")) {
                numbers.add(Integer.parseInt(token));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자와 콤마(,)를 제외한 문자는 입력할 수 없습니다.");
        }
        return numbers;
    }

    private LottoBonus readLottoBonus(Lotto lotto) {
        LottoBonus lottoBonus;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = parseBonusNumber(Console.readLine());
                lottoBonus = new LottoBonus(lotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoBonus;
    }

    private int parseBonusNumber(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void printLottoResult(Map<Place, Integer> lottoResult) {
        DecimalFormat wonFormat = new DecimalFormat("###,###원");
        System.out.println("당첨 통계" + "\n" + "---");
        System.out.println(Place.FIFTH.needHitCount
                + "개 일치 (" + wonFormat.format(Place.FIFTH.prize) + ") - "
                + lottoResult.get(Place.FIFTH) + "개");
        System.out.println(Place.FOURTH.needHitCount
                + "개 일치 (" + wonFormat.format(Place.FOURTH.prize) + ") - "
                + lottoResult.get(Place.FOURTH) + "개");
        System.out.println(Place.THIRD.needHitCount
                + "개 일치 (" + wonFormat.format(Place.THIRD.prize) + ") - "
                + lottoResult.get(Place.THIRD) + "개");
        System.out.println(Place.SECOND.needHitCount
                + "개 일치, 보너스 볼 일치 (" + wonFormat.format(Place.SECOND.prize) + ") - "
                + lottoResult.get(Place.SECOND) + "개");
        System.out.println(Place.FIRST.needHitCount
                + "개 일치 (" + wonFormat.format(Place.FIRST.prize) + ") - "
                + lottoResult.get(Place.FIRST) + "개");
    }

    private void printSurplusRate(Map<Place, Integer> lottoResult, int pay) {
        System.out.printf("총 수익률은 %.1f%%입니다.", calculateSurplusRate(lottoResult, pay));
    }

    private float calculateSurplusRate(Map<Place, Integer> lottoResult, int pay) {
        long totalSurplus = 0;
        for (Place place : lottoResult.keySet()) {
            totalSurplus += place.prize * lottoResult.get(place);
        }
        return (float) totalSurplus / pay * 100;
    }
}

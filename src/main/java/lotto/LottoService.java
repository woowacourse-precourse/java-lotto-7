package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoService {
    Validation validation;
    InputManager inputManager;
    List<Lotto> lottos;
    List<Integer> winnings;
    String bonusNumber;
    long money;

    public LottoService(Validation validation, InputManager inputManager) {
        this.validation = validation;
        this.inputManager = inputManager;
        lottos = new ArrayList<>();
    }

    public void run() {
        inputMoney();
        inputLottoNumbers();
        inputBonusNumber();
        getResult();
    }

    public void inputMoney() {
        String inputMoney;
        while (true) {
            try {
                inputMoney = inputManager.input("구입금액을 입력해 주세요.");
                validation.isRightInputMoney(inputMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        money = Long.parseLong(inputMoney);
        createLottos(inputMoney);
    }

    private void createLottos(String money) {
        long count = Long.parseLong(money) / 1000;
        System.out.println(count+"개를 구매했습니다.");
        for (long i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        lottos.forEach(lotto -> System.out.println(lotto.printNumber()));
        System.out.println();
    }

    public void inputLottoNumbers() {
        while (true) {
            try {
                String winningNumber = inputManager.input("당첨 번호를 입력해 주세요.");

                validation.isRightInputLottos(winningNumber);

                List<Integer> winnings = Arrays.stream(winningNumber.split(",")).mapToInt(Integer::valueOf).boxed().toList();
                validation.isDistinctNumber(winnings);
                this.winnings = winnings;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                String bonusNumber = inputManager.input("보너스 번호를 입력해 주세요.");

                validation.isRightLottoNumber(bonusNumber);
                validation.isContainWinningNumber(Integer.parseInt(bonusNumber), winnings);
                this.bonusNumber = bonusNumber;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getResult() {
        Map<Integer, Integer> map = new HashMap<>();
        int[] prizeMoney = new int[]{2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};
        String[] result = {
                "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - ",
        };

        for (Lotto lotto : lottos) {
            int rank = lotto.getWinningNumber(winnings, Integer.parseInt(bonusNumber));
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }

        double ratio = getRatio(prizeMoney, map);
        printResult(result, map, ratio);
    }

    private double getRatio(int[] prizeMoney, Map<Integer, Integer> map) {
        int sum = 0;
        for (int i = 0; i < prizeMoney.length; i++) {
            sum += map.getOrDefault(i + 1, 0) * prizeMoney[i];
        }
        return ((double) sum / money) * 100;
    }

    private static void printResult(String[] result, Map<Integer, Integer> map, double ratio) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + map.getOrDefault(result.length - i, 0) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", ratio) + "%입니다.");
    }
}

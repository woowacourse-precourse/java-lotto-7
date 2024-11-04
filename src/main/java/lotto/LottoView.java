package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import lotto.dto.LottoRequest;
import lotto.dto.LottoResponse;

public class LottoView {

    String winNum, bonusNum;
    double purchaseAmount;
    int lottoNum;

    LottoModel lottoModel;
    ArrayList<Lotto> lottoList;
    Lotto winLotto;

    LottoView(LottoModel lottoModel) {
        this.lottoModel = lottoModel;
    }

    public LottoRequest readInput() {

        readPurchaseAmount();
        writeLottoNum();
        printLotto();
        readWinNum();
        readBonusNum();
        Console.close();

        return new LottoRequest(purchaseAmount, lottoNum, winNum, bonusNum);
    }

    /* 구입금액과 로또 갯수 입력 */
    private void readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                purchaseAmount = Double.parseDouble(input);
                /* 1000원 이상, 단위인지 확인 */
                validatePurchaseAmount(purchaseAmount);
                lottoNum = howMany(purchaseAmount);
                break; // 유효한 입력이므로 반복문 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
                System.out.println("다시 입력해 주세요:");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요:");
            }
        }
    }

    /* 로또 갯수 만큼 생성 */
    private void writeLottoNum() {
        System.out.println(lottoNum + "개를 구매했습니다.");
        lottoList = lottoModel.makeLotto(lottoNum);
    }

    /* 당첨번호 */
    private void readWinNum() {
        while(true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winNum = Console.readLine();
                winLotto = toLotto(winNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요:");
            }
        }
    }
    /* 보너스번호 입력 */
    private void readBonusNum() {
        while(true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNum = Console.readLine();
                validateBonusNum(bonusNum);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요:");
            }
        }
    }

    private void validateBonusNum(String bonusNum) throws IllegalArgumentException {
        try {
            int bonus = Integer.parseInt(bonusNum);
            validateBonusRange(bonus);
            validateBonusNotInWinningNumbers(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateBonusRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNotInWinningNumbers(int bonus) {
        if (winLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validatePurchaseAmount(double purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 숫자여야 합니다.");
        }
    }

    private Lotto toLotto(String bonusNum) throws IllegalArgumentException {
        StringTokenizer st = new StringTokenizer(bonusNum,",");
        List<Integer> list = new LinkedList<>();
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        return new Lotto(list);
    }

    private static int howMany(double money) {
        return (int) (money / 1000);
    }

    private void printLotto() {
        String result = lottoList.stream()
                .map(lotto -> "[" + lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) + "]")
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    public void printResult(LottoResponse lottoResponse) {
        int[] lottoRanks = lottoResponse.lottoRanks();
        int EA = lottoResponse.EA();
        double rate = lottoResponse.rate();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(EA + "개를 구매했습니다.");
        System.out.println("3개 일치 (5,000원) - " + lottoRanks[1] + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoRanks[2] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoRanks[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRanks[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoRanks[5] + "개");
        System.out.println("총 수익률은 "+ rate +"%입니다.");
    }
}

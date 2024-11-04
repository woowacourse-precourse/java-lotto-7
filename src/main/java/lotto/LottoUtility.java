package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoUtility {
    /**
     * 당첨번호 문자열을 List 형태로 변환
     * @param input 사용자 입력값
     * @return 당첨번호 리스트
     */
    public List<Integer> stringToWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
        return numbers;
    }

    /**
     * 등수별 당첨건수 정보를 반환
     * @param standard 등수
     * @param lottoCount 당첨건수
     * @return 등수별 당첨정보 (예시 : 6개 일치 ( 2,000,000,000원) - 1개)
     */

    public String getWinningInfoMessage(LottoWinningStandard standard, int lottoCount) {
        if(standard.equals(LottoWinningStandard.SECOND_PRIZE)) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoCount + "개";
        }

        DecimalFormat formatter = new DecimalFormat("#,###");
        String prize = formatter.format(standard.getPrizeMoney());
        return standard.getMatchedNumberCount() + "개 일치 (" + prize + "원) - " + lottoCount + "개";
    }

    /**
     * 일치하는 당첨번호와 보너스 번호 개수를 확인하여 등수를 반환
     * @param matchedNumberCount 일치하는 당첨번호 개수
     * @param matchedBonusNumberCount 일치하는 보너스번호 개수
     * @return 당첨 등수, 당첨조건에 해당하지 않는 경우 null 반환
     */
    public LottoWinningStandard getLottoWinningStandard(int matchedNumberCount, int matchedBonusNumberCount) {
        if (matchedNumberCount == 6) {
            return LottoWinningStandard.FIRST_PRIZE;
        }
        if (matchedNumberCount == 5 && matchedBonusNumberCount == 1) {
            return LottoWinningStandard.SECOND_PRIZE;
        }
        if (matchedNumberCount == 5) {
            return LottoWinningStandard.THIRD_PRIZE;
        }
        if (matchedNumberCount == 4) {
            return LottoWinningStandard.FOURTH_PRIZE;
        }
        if (matchedNumberCount == 3) {
            return LottoWinningStandard.FIFTH_PRIZE;
        }
        return null;
    }

    /**
     * 총 수익률 정보가 담긴 메시지를 반환
     * @param returnAmount 수익금액
     * @param purchaseAmount 구입금액
     * @return 수익률 정보 (예시 : 총 수익률은 100.0%입니다.)
     */
    public String getReturnRateMessage(double returnAmount, double purchaseAmount) {
        double returnRate = (returnAmount / purchaseAmount) * 100.0;
        returnRate = Math.round(returnRate * 100) / 100.0;

        DecimalFormat formatter = new DecimalFormat("#,##0.0");
        String returnRateString = formatter.format(returnRate);
        return "총 수익률은 " + returnRateString + "%입니다.";
    }

    /**
     * 등수 별 총 당첨액을 반환
     * @param standard 등수
     * @param lottoCount 당첨건수
     * @return 등수 별 상금액 * 당첨 건수
     */
    public long getTotalPrizeByLottoWinningStandard(LottoWinningStandard standard, int lottoCount) {
        return (long) standard.getPrizeMoney() * lottoCount;
    }

    /**
     * 구입금액을 입력 받아 로또를 발행
     * @return 발행된 로또 정보
     */
    public LottoCreate getLottoCreate() {
        LottoCreate lottoCreate = null;
        while (lottoCreate == null) {
            String input = Console.readLine();
            try {
                lottoCreate = new LottoCreate(input);
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
        return lottoCreate;
    }

    /**
     * 사용자 입력을 통해 로또 당첨번호를 생성
     * @return 당첨번호(Lotto 인스턴스)
     */
    public Lotto getWinningLotto() {
        Lotto lotto = null;
        while(lotto == null) {
            String input = Console.readLine();
            try {
                lotto = new Lotto(stringToWinningNumbers(input));
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
        return lotto;
    }

    /**
     * 사용자 입력을 통해 보너스 번호를 생성
     * @param winningLotto 당첨번호
     * @return 보너스번호
     */
    public int getBonusNumber(Lotto winningLotto) {
        boolean stop = false;
        int bonus = 0;
        while (!stop) {
            String input = Console.readLine();
            try {
                bonus = bonusValidate(input);
                if (bonus > 0 && bonusDuplicate(winningLotto, bonus)) {
                    stop = true;
                }
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
        return bonus;
    }

    private boolean bonusDuplicate(Lotto winningLotto, int bonus) {
        boolean isDuplicated = winningLotto.getNumbers().stream().anyMatch(number -> number == bonus);
        if (isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return true;
    }

    private int bonusValidate(String input) {
        int bonus = 0;
        try {
            bonus = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            printMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonus;
    }

    /**
     * 문자열 출력
     * @param message 출력할 문구
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}

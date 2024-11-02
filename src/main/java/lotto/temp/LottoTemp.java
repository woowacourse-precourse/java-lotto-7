package lotto.temp;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.CommonIo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoTemp {
    private final CommonIo io;

    public LottoTemp(CommonIo io) {
        this.io = io;
    }

    public void printRequestPurchase() {
        io.printMessage("구입금액을 입력해 주세요.");
    }

    public String inputPurchaseAmount() {
        return io.receiveInput();
    }

    public int convertInputToInt(String input) {
        return io.convertStringToInt(input);
    }

    public int convertMoneyToTicket(int amount) {
        return amount / 1000;
    }

    public Lotto createSingleLotto() {
        List<Integer> singleLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(singleLottoNumber);
    }

    public List<Lotto> createMultipleLottos(int ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(i -> createSingleLotto())
                .toList();

        return lottos;
    }

    public void printTicketCount(int ticketCount){
        io.printMessage(ticketCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottoNumbers(List<Lotto> lottos){
        lottos.forEach(lotto -> io.printMessage(lotto.toString()));
    }

    public void printRequestWinningNumbers(){
        io.printMessage("당첨 번호를 입력해 주세요.");
    }

    public String inputWinningNumbers() {
        return io.receiveInput();
    }


    // TODO: 문자열 분리와 정수 리스트 변경을 한번에 하고 있음. 수정 필요
    public List<Integer> createWinningNumbers(String rawWinningNumbers) {
        String[] numbers = rawWinningNumbers.split(",");

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public void printRequestBonusNumber(){
        io.printMessage("보너스 번호를 입력해 주세요.");
    }

    public String inputBonusNumber() {
        return io.receiveInput();
    }

    public void printStaticsFormat(){
        io.printMessage("당첨 통계");
        io.printMessage("---");
    }

    // TODO : 일치 숫자 계산과 결과를 리스트로 만드는 기능의 분리 필요
    public List<Integer> compareLottos(List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> matches = new ArrayList<>();

        lottos.forEach(lotto -> {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            matches.add(matchCount);
        });

        return matches;
    }

    public boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    // TODO : 반환형 수정 필요할 수 있음
    public String determineRank(int matchCount, boolean isBonusContain) {
        String rank = "";

        if (matchCount < 3) {
            return "꽝";
        }
        if (matchCount == 3){
            return "5등";
        }
        if (matchCount == 4){
            return "4등";
        }
        if (matchCount == 5 && !isBonusContain){
            return "3등";
        }
        if (matchCount == 5 && isBonusContain){
            return "2등";
        }
        if (matchCount == 6){
            return "1등";
        }

        return rank;
    }

    // TODO : 심각!!!
    public Map<String,Integer> finalRank(List<String> ranking){
        Map<String,Integer> ranks = new HashMap<>();
        int noRank = 0;
        int rank5 = 0;
        int rank4 = 0;
        int rank3 = 0;
        int rank2 = 0;
        int rank1 = 0;

        for (String s : ranking) {
            if (s.equals("꽝")) {
                noRank++;
            }
            if (s.equals("5등")) {
                rank5++;
            }
            if (s.equals("4등")) {
                rank4++;
            }
            if (s.equals("3등")) {
                rank3++;
            }
            if (s.equals("2등")) {
                rank2++;
            }
            if (s.equals("1등")) {
                rank1++;
            }
        }

        ranks.put("꽝",noRank);
        ranks.put("5등",rank5);
        ranks.put("4등",rank4);
        ranks.put("3등",rank3);
        ranks.put("2등",rank2);
        ranks.put("1등",rank1);

        return ranks;
    }

    public void printProfit(int profit) {
        io.printMessage("총 수익률은 " + profit + "%입니다.");
    }
}

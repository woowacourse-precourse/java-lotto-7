package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.dto.LottoRequest;
import lotto.dto.LottoResponse;

public class LottoModel {

    ArrayList<Lotto> lotto;
    ArrayList<Integer> winNum;
    ArrayList<LottoRank> totalWinNum;
    int[] winners;
    double profit, rate;

    /* 당첨번호와 구매 로또와 맞춰보는 로직 */
    public LottoResponse matchMaking(LottoRequest lottoRequest) {

        int loop = lottoRequest.lottoNum(), bonusNum = Integer.parseInt(lottoRequest.bonusNum());
        winNum = toList(lottoRequest.winNum());
        totalWinNum = new ArrayList<>();
        winners = new int[6];

        /* 로또 갯수만큼 순위 생성 */
        for (int i = 0; i < loop; i++) {
            int cnt = howManyWinNum(i);
            boolean flag = isBonusNum(i, bonusNum);
            setWinners(cnt, flag);
        }
        rate = getEarningRate(lottoRequest.purchaseAmount());
        /* 승자와, 총 수익 */
        return new LottoResponse(winners, rate, loop);
    }

    private double getEarningRate(double purchaseAmount) {
        double rate = (profit / purchaseAmount) * 100;
        return Math.round(rate * 100) / 100.0; // 소수점 둘째 자리까지 반올림
    }

    private void setWinners(int cnt, boolean flag) {
        LottoRank rank = LottoRank.valueOf(cnt, flag);
        int index = rank.getIndex();
        winners[index]++;
        if (rank.isWinningRank()) {
            profit += rank.getPrize();
        }
    }

    private int howManyWinNum(int idx) {
        Lotto curLotto = lotto.get(idx);
        Set<Integer> winningNumbers = new HashSet<>(winNum);
        Set<Integer> lottoNumbers = new HashSet<>(curLotto.getNumbers());

        winningNumbers.retainAll(lottoNumbers);
        return winningNumbers.size();
    }

    private boolean isBonusNum(int idx, int bonusNum) {
        Lotto curLotto = lotto.get(idx);
        return curLotto.getNumbers().contains(bonusNum);
    }

    private ArrayList<Integer> toList(String winNum) {
        return Arrays.stream(winNum.split(","))
                .map(String::trim) // 공백 제거
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /* 로또 갯수만큼 생성하여 ArrayList<> 형으로 반환 */
    public ArrayList<Lotto> makeLotto(int lottoNum) {
        initLottoList(lottoNum);
        return lotto;
    }

    /* 난수 생성하여 lotto list 입력 */
    private List<Integer> makeRandomNumberList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    /* lotto list 초기화 */
    private void initLottoList(int lottoNum) {
        lotto = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            Lotto lList = new Lotto(makeRandomNumberList());
            lotto.add(lList);
        }
    }
}

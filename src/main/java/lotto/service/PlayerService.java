package lotto.service;

import lotto.domain.lotto.Bonus;
import lotto.Lotto;
import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import lotto.domain.player.PlayerResult;
import lotto.util.RandomNumberGenerator;

import java.util.HashSet;
import java.util.List;

public class PlayerService {

    private static int LOTTO_PRICE = 1000;
    private static int FIRST_PLACE_AMOUNT = 2000000000;
    private static int SECOND_PLACE_AMOUNT = 30000000;
    private static int THIRD_PLACE_AMOUNT = 1500000;
    private static int FOURTH_PLACE_AMOUNT = 50000;
    private static int FIFTH_PLACE_AMOUNT = 5000;

    private final Player player;
    private final Lotto lotto;
    private final Bonus bonus;
    private final RandomNumberGenerator numberGenerator;

    public PlayerService(Player player, Lotto lotto, Bonus bonus) {
        this.player = player;
        this.lotto = lotto;
        this.bonus = bonus;
        this.numberGenerator = new RandomNumberGenerator();
    }

    // 1. 구매할 수 있는 로또의 개수
    public int updateLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        player.updateLottoCount(lottoCount);
        return lottoCount;
    }

    // 2. 구매할 수 있는 개수만큼 로또를 생성하는 기능
    public void addLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            player.addLotto(createLotto());
        }
    }

    private PlayerLotto createLotto() {
        List<Integer> lottoNumbers = numberGenerator.generateLottoNumbers();
        return new PlayerLotto(lottoNumbers);
    }

    // 5. 로또 당첨 여부를 판단하는 기능
    public void calculateWinningCount(PlayerLotto playerLotto) {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(lotto.getNumbers());
        for (Integer lottoNumber : playerLotto.getLottoNumbers()) {
            if (set.contains(lottoNumber)) {
                playerLotto.increaseWinningCount();
            }
        }

        if (playerLotto.getWinningCount() == 5){
           calculateBonusCount(playerLotto);
        }
    }

    private void calculateBonusCount(PlayerLotto playerLotto) {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(playerLotto.getLottoNumbers());
        if (set.contains(bonus.getNumber())) {
            playerLotto.increaseBonusCount();
        }
    }

    // 6. 수익률을 계산하는 기능
    public void updatePlayerResult(Player player) {
        PlayerResult playerResult = player.getPlayerResult();
        calculateWinningRanks(player.getLottos(), playerResult);

        long profit = calculateProfit(playerResult);
        playerResult.updateProfit(profit);

        int purchasePrice = player.getLottoCount() * LOTTO_PRICE;
        playerResult.updateProfitRate(calculateProfitRate(purchasePrice, profit));
    }

    public void calculateWinningRanks(List<PlayerLotto> playerLottos, PlayerResult playerResult) {
        for (PlayerLotto playerLotto : playerLottos) {
            calculateWinningRank(playerLotto, playerResult);
        }
    }

    private void calculateWinningRank(PlayerLotto playerLotto, PlayerResult playerResult) {
        if (checkFirstPlace(playerLotto)){
            playerResult.increaseFirstPlace();
        }
        if (checkSecondPlace(playerLotto)){
            playerResult.increaseSecondPlace();
        }
        if (checkThirdPlace(playerLotto)){
            playerResult.increaseThirdPlace();
        }
        if (checkFourthPlace(playerLotto)){
            playerResult.increaseFourthPlace();
        }
        if (checkFifthPlace(playerLotto)){
            playerResult.increaseFifthPlace();
        }
    }

    private boolean checkFirstPlace(PlayerLotto playerLotto) {
        if (playerLotto.getWinningCount() == 6){
            return true;
        }
        return false;
    }

    private boolean checkSecondPlace(PlayerLotto playerLotto) {
        if (playerLotto.getWinningCount() == 5 && playerLotto.getBonusCount() == 1) {
            return true;
        }
        return false;
    }

    private boolean checkThirdPlace(PlayerLotto playerLotto) {
        if (playerLotto.getWinningCount() == 5 && playerLotto.getBonusCount() == 0) {
            return true;
        }
        return false;
    }

    private boolean checkFourthPlace(PlayerLotto playerLotto) {
        if (playerLotto.getWinningCount() == 4){
            return true;
        }
        return false;
    }

    private boolean checkFifthPlace(PlayerLotto playerLotto) {
        if (playerLotto.getWinningCount() == 3){
            return true;
        }
        return false;
    }

    public long calculateProfit(PlayerResult playerResult) {
        long profit = 0;
        profit += (long) playerResult.getFirstPlace() * FIRST_PLACE_AMOUNT;
        profit += (long) playerResult.getSecondPlace() * SECOND_PLACE_AMOUNT;
        profit += (long) playerResult.getThirdPlace() * THIRD_PLACE_AMOUNT;
        profit += (long) playerResult.getFourthPlace() * FOURTH_PLACE_AMOUNT;
        profit += (long) playerResult.getFifthPlace() * FIFTH_PLACE_AMOUNT;
        return profit;
    }

    public float calculateProfitRate(int price, long profit) {
        return ((float) profit / price) * 100;
    }

    public Player getPlayer() {
        return player;
    }
}

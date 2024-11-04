package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private static Player player;
    private List<Lotto> lottos;
    private int usingPrice;
    private int earningPrice;
    private double priceRatio;
    private HashMap<WinType, Integer> winCount;

    private Player() {
        this.lottos = new ArrayList<>();
        this.usingPrice = 0;
        this.earningPrice = 0;
        this.priceRatio = 0;
        this.winCount = new HashMap<>();
    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public void addUsingPrice(int price) {
        this.usingPrice += price;
    }

    public List<Lotto> addLotto(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
        return lottos;
    }

    public void addWinCount(WinType winType) {
        int currentCount = this.winCount.getOrDefault(winType, 0);
        this.winCount.put(winType, currentCount + 1);
    }

    public void calculateResult() {
        calculateTotalPrice();
        calculatePriceRatio();
    }

    private void calculateTotalPrice() {
        for (WinType winType : winCount.keySet()) {
            addEarningPrice(winType.getPrice() * winCount.get(winType));
        }
    }

    private void calculatePriceRatio() {
        this.priceRatio = (double) this.earningPrice / this.usingPrice * 100;
    }

    private void addEarningPrice(int price) {
        this.earningPrice += price;
    }

    public int getUsingPrice() {
        return usingPrice;
    }

    public double getPriceRatio() {
        return priceRatio;
    }

    public HashMap<WinType, Integer> getWinCount() {
        return winCount;
    }
}

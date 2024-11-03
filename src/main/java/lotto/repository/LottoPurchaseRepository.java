package lotto.repository;

import lotto.domain.LottoPurchase;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseRepository {

    List<LottoPurchase> lottoPurchases = new ArrayList<>();

    public void save(LottoPurchase lottoPurchase) {
        lottoPurchases.add(lottoPurchase);
    }

    public void deleteByIndex(int index) {
        lottoPurchases.remove(index);
    }

    public void delete(LottoPurchase lottoPurchase) {
        lottoPurchases.remove(lottoPurchase);
    }

    public void deleteAll() {
        lottoPurchases.clear();
    }

    public List<LottoPurchase> findAll() {
        return lottoPurchases;
    }

    public LottoPurchase findByIndex(int index) {
        return lottoPurchases.get(index);
    }

    public LottoPurchase findOne() {
        return lottoPurchases.getLast();
    }

    public int findIndexByLottoPurchase(LottoPurchase lottoPurchase) {
        return lottoPurchases.indexOf(lottoPurchase);
    }

    public int size() {
        return lottoPurchases.size();
    }

    public boolean isEmpty() {
        return lottoPurchases.isEmpty();
    }

}

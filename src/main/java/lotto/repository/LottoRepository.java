package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    List<Lotto> lottoList = new ArrayList<>();

    public void save(Lotto lotto) {
        lottoList.add(lotto);
    }

    public void save(List<Lotto> lottos) {
        lottoList.addAll(lottos);
    }

    public Lotto findOne() {
        return lottoList.getLast();
    }

    public Lotto findByIndex(int index) {
        return lottoList.get(index);
    }

    public List<Lotto> findAll() {
        return lottoList;
    }

    public void delete(Lotto lotto) {
        lottoList.remove(lotto);
    }

    public void delete(List<Lotto> lottos) {
        lottoList.removeAll(lottos);
    }

    public void deleteByIndex(int index) {
        lottoList.remove(index);
    }

    public void deleteAll() {
        lottoList.clear();
    }

}

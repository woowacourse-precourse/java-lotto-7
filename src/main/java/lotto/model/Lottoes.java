package lotto.model;

import lotto.view.OutputView;

import java.util.List;

public class Lottoes {
    private final List<Lotto> lottoes;

    public Lottoes(PriceToBuyLotto priceToBuyLotto){
        lottoes = LottoFactory.drawLottoesByPrice(priceToBuyLotto);
    }

    public void printLottoesInfo(){
        OutputView.printNumberOfLotto(lottoes.size());
        lottoes.forEach(Lotto::printLottoInfo);
    }

    public List<Lotto> getLottoes(){
        return lottoes;
    }

    public Integer getLottoesCount(){
        return lottoes.size();
    }
}

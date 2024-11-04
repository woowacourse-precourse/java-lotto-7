package lotto;

import java.util.List;

public class BundleOfLotto {
    private List<List<Integer>> bundle;
    private int amount = Amount.get();

    public void BundleOfLotto(){
        for(int i=0; i<amount; i++) {
            //List<Integer> list = Lotto.get();
            //addToBundle(list);
        }
    }

    private void addToBundle(List<Integer> lotto){
        bundle.add(lotto);
    }

    private void addAlltoBundle(){

    }

}

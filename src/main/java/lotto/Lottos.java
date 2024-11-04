package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	
    private List<Lotto> lottos;
    public List<Lotto> getLottos() { return lottos; }
    
    public Lottos() 
    {
        lottos = new ArrayList<Lotto>();
    }

    public void makeLottos(int num)
    {
        for (int i = 0; i < num;i++)
        {
            Lotto lotto = new Lotto(Lotto.makeRandomNumbers());
            lotto.getNumbers().sort(Integer::compareTo);
            lottos.add(lotto);
        }
    }
    
    public void printLottos()
    {
    	for (Lotto lotto : lottos)
    	{
    		System.out.println(lotto.getNumbers());
    	}
    }
}

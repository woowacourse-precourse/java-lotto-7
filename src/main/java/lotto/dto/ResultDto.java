package lotto.dto;

import java.util.List;

public class ResultDto {
    private Receipt receipt;
    private List<Lotto> lottos;
    public ResultDto(Receipt receipt, List<Lotto> lottos){
        this.receipt = receipt;
        this.lottos = lottos;
    }
    public Receipt getReceipt(){
        return receipt;
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}

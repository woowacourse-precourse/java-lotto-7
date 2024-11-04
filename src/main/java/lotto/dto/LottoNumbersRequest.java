package lotto.dto;

public class LottoNumbersRequest {
    private String lottoNumbers;

    public LottoNumbersRequest(String lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public String getLottoNumbers(){
        return lottoNumbers;
    }
}

package t1708e.assgniment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1708e.assgniment.dto.CoinDTO;
import t1708e.assgniment.dto.MarketDTO;
import t1708e.assgniment.entity.Coin;
import t1708e.assgniment.entity.Market;
import t1708e.assgniment.repository.CoinRepository;
import t1708e.assgniment.repository.MarketRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class MarketService {

    @Autowired
    MarketRepository marketRepository;

    @Autowired
    CoinRepository coinRepository;

    public List<MarketDTO> getListMarket(){
        List<MarketDTO> list = new ArrayList<>();
        for (Market market:marketRepository.findAll()){
            list.add(new MarketDTO.MarketDTOBuilder()
                    .withName(market.getName())
                    .withId(market.getId())
                    .withDescription(market.getDescription())
                    .withStatus(market.getStatus())
                    .withListCoin(coinRepository.findAllByMarketId(market.getId()))
                    .build());
        }
        return list;
    }

    public Market create(Market market) {
        market.setStatus(1);
        market.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        market.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return marketRepository.save(market);
    }
}

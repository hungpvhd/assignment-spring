package t1708e.assgniment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t1708e.assgniment.dto.CoinDTO;
import t1708e.assgniment.dto.MarketDTO;
import t1708e.assgniment.entity.Coin;
import t1708e.assgniment.entity.Market;
import t1708e.assgniment.entity.rest.RESTResponse;
import t1708e.assgniment.service.CoinService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/coins")
public class CoinController {

    @Autowired
    CoinService coinService;

    @PostMapping
    public ResponseEntity<Object> saveCoin(@RequestBody Coin coin){
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Success")
                .addData(coinService.create(coin))
                .build(),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getListCoin(){
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Success")
                .addData(coinService.getListCoin())
                .build(),
                HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCoinByMarketId(@PathVariable int id){
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Success")
                .addData(coinService.getListCoinByMarketId(id))
                .build(),
                HttpStatus.OK);
    }
}

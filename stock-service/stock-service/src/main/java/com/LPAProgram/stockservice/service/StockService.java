package com.LPAProgram.stockservice.service;


import com.LPAProgram.stockservice.VO.ResponseTemplateVO;
import com.LPAProgram.stockservice.VO.User;
import com.LPAProgram.stockservice.entity.Stock;
import com.LPAProgram.stockservice.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Stock saveStock(Stock stock) {
        log.info("Inside saveUser of UserService");
        return stockRepository.save(stock);
    }


    public ResponseTemplateVO getMedicineStockWithUser(Long medicineId) {
        log.info("Inside getMedicineStockWithUser of StockService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Stock stock = stockRepository.findByMedicineId(medicineId);

        User user =
                restTemplate.getForObject("http://USER-SERVICE/users/" + stock.getUserId()
                        ,User.class);

        vo.setUser(user);
        vo.setStock(stock);

        return  vo;
    }


}

package com.melon.apk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melon.apk.entity.Money;
import com.melon.apk.mapper.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管钱
 */
@RestController
@RequestMapping("/money")
public class MoneyController {
    private MoneyMapper moneyMapper;
    @Autowired
    public void setMoneyMapper(MoneyMapper moneyMapper) {
        this.moneyMapper = moneyMapper;
    }

    /**
     * 查看所有主题
     */
    @GetMapping("/all")
    public List<Money> selectAll() {
        QueryWrapper<Money> query = new QueryWrapper<>();
        query.orderByAsc("level");
        List<Money> moneyList = moneyMapper.selectList(query);
        int sum = 0;
        for(Money money : moneyList)
        {
            sum += money.getAmount();
        }

        for(Money money : moneyList)
        {
            money.setRatio(money.getAmount()*100/sum);
        }

        return moneyList;
    }

    /**
     * 增加
     * Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
     * 不要加@RequestBody注解
     */
    @PostMapping
    public Object addMoney(Money money) {
        return moneyMapper.insert(money);
    }
}

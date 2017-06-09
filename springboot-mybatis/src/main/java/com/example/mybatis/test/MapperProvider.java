package com.example.mybatis.test;

import com.example.mybatis.entity.Account;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperProvider {

    public String addAll(Map map){
        List<Account> accountList = (List<Account>)map.get("list");
        StringBuffer sb = new StringBuffer();
        sb.append("insert into account(name,money) values ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].name},#'{'list[{0}].money})");
        for(int i=0;i<accountList.size();i++){
            if(i>0)
                sb.append(",");
            sb.append(mf.format(new Object[]{i,i}));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        MapperProvider mapperProvider = new MapperProvider();
        List<Account> list = new ArrayList<>();
        list.add(new Account());
        list.add(new Account());
        list.add(new Account());

        Map map = new HashMap();
        map.put("list",list);

        System.out.print(mapperProvider.addAll(map));

    }

}

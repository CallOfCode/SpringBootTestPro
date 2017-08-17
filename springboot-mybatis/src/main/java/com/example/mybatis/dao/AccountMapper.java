package com.example.mybatis.dao;

import com.example.mybatis.entity.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface AccountMapper {

    @Insert("insert into account(name,money) values(#{name},#{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @InsertProvider(type = AccountMapperProvider.class,method = "addAll")
    int addAll(@Param("list") List<Account> list);

    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    int update(@Param("name")String name,@Param("money") double money,@Param("id") int id);

    @Delete("delete from account where id=#{id}")
    int delete(@Param("id") int id);

    @Select("select id,name,money from account where id=#{id}")
    Account findAccount(@Param("id") int id);

    @SelectProvider(type = AccountMapperProvider.class,method = "findAccountByNameAndMoney")
    List<Account> findAccountList(@Param("name") String name,@Param("money") Double money);

//    @Select("select id,name,money from account")
//    List<Account> findAccountList();

    @Select("select id,name,money from account")
    List<Account> findAccountPageList();

    static class AccountMapperProvider{
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

        public String findAccountByNameAndMoney(Map map){
            List<String> sqlArrayList = new ArrayList<>();
            String name = (String)map.get("name");
            Double money = (Double)map.get("money");
            if(!StringUtils.isEmpty(name))
                sqlArrayList.add("name=#{name}");
            if(null!=money)
                sqlArrayList.add("money>=#{money}");

            return new SQL(){
                {
                    SELECT("id,name,money");
                    FROM("account");
                    WHERE(sqlArrayList.toArray(new String[sqlArrayList.size()]));
                }
            }.toString();
        }
    }
}

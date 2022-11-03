package com.jpaul.dao;

import com.jpaul.model.Category;

import java.util.List;

public interface IDAO<O, String> {
    /* Create / Read / Update / Delete /Search / GotoID */
    O create(O o) throws Exception;
    List<O> read() throws Exception;
    O update(O o) throws Exception;
    O delete(O o) throws Exception;
    List<O> search(String pattern) throws Exception;
    O gotoId(O o) throws Exception;
}

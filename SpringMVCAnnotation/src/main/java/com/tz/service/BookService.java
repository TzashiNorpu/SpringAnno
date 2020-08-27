package com.tz.service;


import javax.annotation.Resource;
import javax.inject.Inject;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tz.dao.BookDao;


@Service
@Data
public class BookService {

    //@Qualifier("bookDao")
    //@Autowired(required=false)
    //@Resource(name="bookDao2")
    @Inject
    private BookDao bookDao;
}

package com.zyc.annotation.spring.tx;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserService {

    void insertUser();
}
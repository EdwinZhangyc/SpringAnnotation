package com.zyc.annotation.tx;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserService {

    void insertUser();
}
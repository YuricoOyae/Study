package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.GuysRequest;
import com.example.demo.entity.GuysEntity;
import com.example.demo.repository.GuysRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GuysService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private GuysRepository guysRepository;


  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<GuysEntity> searchAll() {
    return guysRepository.findAll();
  }
  public void create(GuysRequest guysRequest) {
	    Date now = new Date();
	    GuysEntity guys = new GuysEntity();
	    guys.setName(guysRequest.getName());
	    guys.setAddress(guysRequest.getAddress());
	    guys.setPhone(guysRequest.getPhone());
	    guys.setCreateDate(now);
	    guys.setUpdateDate(now);
	    guysRepository.save(guys);
	  }
}
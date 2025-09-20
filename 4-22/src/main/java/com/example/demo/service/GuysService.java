package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.GuysRequest;
import com.example.demo.dto.GuysUpdateRequest;
import com.example.demo.entity.GuysEntity;
import com.example.demo.repository.GuysRepository;

/**
 * ガイズ情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GuysService {
  /**
   * ガイズ情報 Repository
   */
  @Autowired
  private GuysRepository guysRepository;


  /**
   * ガイズ情報 全検索
   * @return 検索結果
   */
  public List<GuysEntity> searchAll() {
    return guysRepository.findAll();
  }
  /**
   * ガイズ情報 主キー検索
   * @return 検索結果
   */
  public GuysEntity findById(Integer id) {
      return guysRepository.getOne(id);
  }
  /**
   * ガイズ情報 新規登録
   * @param guys ガイズ情報
   */
  public void create(GuysRequest guysRequest) {
	    Date now = new Date();
	    GuysEntity guys = new GuysEntity();
	    guys.setName(guysRequest.getName());
	    guys.setAddress(guysRequest.getAddress());
	    guys.setPhone(guysRequest.getPhone());

	    if (guysRequest.getJoinDate() != null) {
	        guys.setJoinDate(guysRequest.getJoinDate());
	    } else {
	        guys.setJoinDate(new Date()); // null の場合は現在日時をセット
	    }
	    if (guysRequest.getPromotionDate() != null) {
	        guys.setPromotionDate(guysRequest.getPromotionDate());
	    } else {
	        guys.setPromotionDate(null);
	    }
	    guysRepository.save(guys);
	  }

  /**
   * ガイズ情報 物理削除
   * @param id ユーザーID
   */
  public void delete(Integer id) {
      GuysEntity guys = findById(id);
      guysRepository.delete(guys);
  }
  /**
   * ガイズ情報 更新
   * @param guys ガイズ情報
   */
  public void update(GuysUpdateRequest guysUpdateRequest) {
    GuysEntity guys = findById(guysUpdateRequest.getId());
    guys.setAddress(guysUpdateRequest.getAddress());
    guys.setName(guysUpdateRequest.getName());
    guys.setPhone(guysUpdateRequest.getPhone());
    if (guysUpdateRequest.getJoinDate() != null) {
        guys.setJoinDate(guysUpdateRequest.getJoinDate());
    } else {
        guys.setJoinDate(new Date()); // 今の日時をセット
  
    }

    if (guysUpdateRequest.getPromotionDate() != null) {
        guys.setPromotionDate(guysUpdateRequest.getPromotionDate());
    } else {
        guys.setPromotionDate(null);
    }
    guysRepository.save(guys);
  }
}

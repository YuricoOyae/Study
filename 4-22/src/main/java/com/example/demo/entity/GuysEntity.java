package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ガイズ情報 Entity
 */
@Data
@Entity
@Table(name = "guys", schema = "public")
public class GuysEntity  {

  /**
   * ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;


  /**
   * 名前
   */
  @Column(name = "name")
  private String name;


  /**
   * 住所
   */
  @Column(name = "address")
  private String address;


  /**
   * 電話番号
   */
  @Column(name = "phone")
  private String phone;

  /**
   * 入社日
   */
  @Column(name = "join_date")
  private Date joinDate;


  /**
   * 昇格日
   */
  @Column(name = "promotion_date")
  private Date promotionDate;
}
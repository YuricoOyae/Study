package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * ガイズ情報 リクエストデータ
 */
@Data
public class GuysRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 100, message = "名前は100桁以内で入力してください")
  private String name;
  /**
   * 住所
   */
  @NotEmpty(message = "住所を入力してください")
  @Size(max = 255, message = "住所は255桁以内で入力してください")
  private String address;
  /**
   * 電話番号
   */
  @Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
  private String phone;
  /**
   * 入社日
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date joinDate;

  /**
   * 昇格日
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date promotionDate;
}
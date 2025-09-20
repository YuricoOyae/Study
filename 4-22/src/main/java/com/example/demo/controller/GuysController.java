package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.GuysRequest;
import com.example.demo.dto.GuysUpdateRequest;
import com.example.demo.entity.GuysEntity;
import com.example.demo.service.GuysService;

/**
 * ガイズ情報 Controller
 */
@Controller
public class GuysController {

  /**
   * ガイズ情報 Service
   */
  @Autowired
  GuysService guysService;

  /**
   * ガイズ情報一覧画面を表示
   * @param model Model
   * @return ガイズ情報一覧画面のHTML
   */
  @RequestMapping("/guys/list")
  public String guysList(Model model) {
    List<GuysEntity> guyslist = guysService.searchAll();
    model.addAttribute("guyslist", guyslist);
    return "guys/list";
  }

  /**
   * ガイズ新規登録画面を表示
   * @param model Model
   * @return ガイズ情報一覧画面
   */
  @RequestMapping("/guys/add")
  public String guysRegister(Model model) {
    model.addAttribute("guysRequest", new GuysRequest());
    return "guys/add";
  }

  /**
   * ガイズ新規登録処理
   * @param guysRequest リクエストデータ
   * @param model Model
   * @return ガイズ情報一覧画面 
   */
  @PostMapping("/guys/create")
  public String guysCreate(
      @Validated @ModelAttribute GuysRequest guysRequest,
      BindingResult result,
      Model model) {

    if (result.hasErrors()) {
    	  // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      //エラー判定後の画面遷移
      model.addAttribute("validationError", errorList);
      return "guys/add";
    }
 // ガイズ情報の登録
    guysService.create(guysRequest);
    return "redirect:/guys/list";
  }
  /**
   * ガイズ情報詳細画面を表示
   * @param id 表示するガイズID
   * @param model Model
   * @return ガイズ情報詳細画面
   */
  @GetMapping("/guys/{id}")
  public String guysDetail(@PathVariable Integer id, Model model) {
    GuysEntity guys = guysService.findById(id);
    model.addAttribute("guysData", guys);
    return "guys/view";
  }
  /**
   * ガイズ編集画面を表示
   * @param id 編集対象のID
   * @param model Model
   * @return 編集画面
   */
  @GetMapping("/guys/{id}/edit")
  public String guysEdit(@PathVariable Integer id, Model model) {
	  /**
	    * 編集対象のガイズ情報を取得
	    */
	  GuysEntity guys = guysService.findById(id);
	// 編集画面用のDTOに格納
    GuysUpdateRequest request = new GuysUpdateRequest();
   request.setId(guys.getId());
   request.setName(guys.getName());
   request.setPhone(guys.getPhone());
   request.setAddress(guys.getAddress());
  model.addAttribute("guysUpdateRequest", request);
    return "guys/edit";
  }

  /**
   * ガイズ更新
   * @param GuysRequest リクエストデータ
   * @param model Model
   * @return ガイズ情報詳細画面
   */
  @PostMapping("/guys/update")
  public String guysUpdate(@Validated @ModelAttribute GuysUpdateRequest guysUpdateRequest,
      BindingResult result,
      Model model) {

    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "guys/edit";
    }
    // ガイズ情報の更新
    guysService.update(guysUpdateRequest);
    return String.format("redirect:/guys/%d", guysUpdateRequest.getId());
  }

  /**
   * ガイズ情報削除処理
   * @param id 削除するID
   * @return 一覧画面へリダイレクト
   */
  @GetMapping("/guys/{id}/delete")
  public String guysDelete(@PathVariable Integer id) {
	   // ガイズ情報の削除
	  guysService.delete(id);
    return "redirect:/guys/list";
  }
   
}
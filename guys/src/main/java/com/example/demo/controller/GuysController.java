package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.GuysRequest;
import com.example.demo.dto.GuysUpdateRequest;
import com.example.demo.entity.GuysEntity;
import com.example.demo.service.GuysService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class GuysController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  GuysService guysService;

  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面のHTML
   */
  @RequestMapping("/guys/list")
  public String guysList(Model model) {
    List<GuysEntity> guyslist = guysService.searchAll();
    model.addAttribute("guyslist", guyslist);
    return "guys/list";
  }

  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/guys/{id}")
  public String guysDetail(@PathVariable Integer id, Model model) {
    return "guys/view";
  }

  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping("/guys/add")
  public String guysRegister(Model model) {
    model.addAttribute("guysRequest", new GuysRequest());
    return "guys/add";
  }
 
  @RequestMapping("/guys/create")
  public String guysCreate(@Validated @ModelAttribute GuysRequest guysRequest, BindingResult result, Model model) {
  }
  @GetMapping("/guys/{id}")
  public String guysDetail(@PathVariable Integer id, Model model) {
    GuysEntity guys = guysService.findById(id);
    model.addAttribute("guysData", guys);
    return "guys/view";

}
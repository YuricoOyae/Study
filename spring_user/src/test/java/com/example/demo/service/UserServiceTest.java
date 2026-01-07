package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@SpringBootTest 
public class UserServiceTest {

	//Step2 テスト対象とモックの作成 
	@Autowired 
	private UserService userService; 

	@MockBean 
	private UserRepository userRepository; // UserRepository をモックに差し替え 
	
	@Test 
	void findById_モックを使ってDB依存を回避(){ 
	// Step3 モックが返すエンティティを準備 
	UserEntity user = new UserEntity(); 
	user.setId(1); 
	user.setName("花子"); 
	//Step4 モックの挙動を設定 
	when(userRepository.getOne (1)).thenReturn(user); 
	//Step5 テスト実行 
	UserEntity result = userService.findById(1); 
	//Step6 検証 
	assertEquals("花子", result.getName()); 
	
	}
}

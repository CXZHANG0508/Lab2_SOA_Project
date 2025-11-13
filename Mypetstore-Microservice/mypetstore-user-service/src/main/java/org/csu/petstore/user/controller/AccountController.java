package org.csu.petstore.user.controller;



import jakarta.servlet.http.HttpSession;

import org.csu.petstore.user.annotation.LogAccount;
import org.csu.petstore.user.annotation.LogAdmin;
import org.csu.petstore.user.common.CommonResponse;
import org.csu.petstore.user.common.ResponseCode;
import org.csu.petstore.user.entity.Account;
import org.csu.petstore.user.entity.SignOn;
import org.csu.petstore.user.service.AccountService;
import org.csu.petstore.user.utils.JwtBlacklist;
import org.csu.petstore.user.utils.JwtUtil;
import org.csu.petstore.user.vo.AccountVO;
import org.csu.petstore.user.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/account")
@Validated
@SessionAttributes
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    HttpSession session;

    // 用户登录
    @LogAccount
    @PostMapping("/tokens")
    @ResponseBody
    public CommonResponse<String> login(@RequestParam String username,
                                        @RequestParam String password) {
        CommonResponse<AccountVO> response = accountService.getAccount(username, password);
        if (response.isSuccess()) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", response.getData().getUsername());
            String token = JwtUtil.generateToken(claims);
            return CommonResponse.createForSuccess(token);
        } else {
            return CommonResponse.createForError("用户名或密码错误");
        }
    }

    // 退出登录
    @LogAccount
    @DeleteMapping("/tokens")
    @ResponseBody
    public CommonResponse<AccountVO> signOut(@RequestHeader("Authorization") String token) {
        JwtBlacklist.addTokenToBlacklist(token);
        return CommonResponse.createForSuccessMessage("用户已退出登录");
    }

    // 获取当前登录用户信息
    @LogAccount
    @PostMapping("")
    @ResponseBody
    public CommonResponse<AccountVO> getLoginAccountInfo(@RequestHeader("Authorization") String token) {
        Map<String, Object> claims = JwtUtil.parseToken(token);
        String username = (String) claims.get("username");
        return accountService.getAccount(username);
    }

    // 用户注册
    @LogAccount
    @PostMapping("/info")
    @ResponseBody
    public CommonResponse<String> newAccount(@RequestBody AccountVO accountVO) {
        CommonResponse<AccountVO> response = accountService.insertAccountInformation(accountVO);
        if (response.isSuccess()) {
            return CommonResponse.createForSuccessMessage("注册成功");
        } else {
            return CommonResponse.createForError(ResponseCode.ERROR.getCode(), "注册失败");
        }

    }


    // 编辑用户信息
    @LogAccount
    @PostMapping("/edit")
    @ResponseBody
    public CommonResponse<String> updateAccount(@RequestBody AccountVO account) {
        CommonResponse<AccountVO> response = accountService.updateAccountInformation(account);
        if (response.isSuccess()) {
            return CommonResponse.createForSuccessMessage("用户信息更新成功");
        } else {
            return CommonResponse.createForError(ResponseCode.ERROR.getCode(), "用户信息更新失败");
        }
    }

//

}
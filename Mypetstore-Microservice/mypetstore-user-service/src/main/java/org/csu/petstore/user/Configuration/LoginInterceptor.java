package org.csu.petstore.user.Configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.csu.petstore.user.common.CommonResponse;
import org.csu.petstore.user.common.ResponseCode;
import org.csu.petstore.user.utils.JwtBlacklist;
import org.csu.petstore.user.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }
        // 令牌验证
        String token = request.getHeader("Authorization");
        try {
            if (JwtBlacklist.isTokenBlacklisted(token)) {
                // 解析失败，返回401
                response.setStatus(401);
                //json格式返回
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"status\": 10, \"msg\": \"用户未登录，请先登录\"}");
                return false;
            }else{
                Map<String,Object> claims = JwtUtil.parseToken(token);
                return true;
            }
        } catch (Exception e) {
            // 解析失败，返回401
            response.setStatus(401);
            //json格式返回
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\": 10, \"msg\": \"用户未登录，请先登录\"}");
            return false;
        }
    }
}

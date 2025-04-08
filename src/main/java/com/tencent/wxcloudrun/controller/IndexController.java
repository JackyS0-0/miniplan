package com.tencent.wxcloudrun.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.tencent.wxcloudrun.config.ApiResponse;

/**
 * index控制器
 */
@Controller

public class IndexController {

  @GetMapping(value = "/test")
  ApiResponse get() {
    return ApiResponse.ok("test");
  }

}

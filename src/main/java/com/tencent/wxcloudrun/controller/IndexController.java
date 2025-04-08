package com.tencent.wxcloudrun.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencent.wxcloudrun.config.ApiResponse;


@RestController
public class IndexController {

  @GetMapping(value = "/test")
  public ApiResponse get() {
    return ApiResponse.ok("test");
  }

}

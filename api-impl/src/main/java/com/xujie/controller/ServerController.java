package com.xujie.controller;

import com.xujie.VO.req.UserRequestDTO;
import com.xujie.common.ResponseEntity;
import com.xujie.convert.UserRequestConvert;
import com.xujie.domain.service.ServerDomainService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerController {
    @Resource
    private ServerDomainService serverDomainService;
    @Resource
    private UserRequestConvert userRequestConvert;

    @PostMapping("isAvailable")
    public ResponseEntity<?> isAvailable(@RequestBody @Validated UserRequestDTO userRequestDTO) {
        Boolean available = serverDomainService.isAvailable(userRequestConvert.dto2bo(userRequestDTO));
        return ResponseEntity.success(available,available?"用户可用":"用户在该区域无法使用");
    }

}

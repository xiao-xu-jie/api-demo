package com.xujie.infra.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xujie.infra.entity.UserArea;
import com.xujie.infra.mapper.UserAreaMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserAreaService extends ServiceImpl<UserAreaMapper, UserArea> {
    public List<UserArea> getUserAvailableAreas(Long userId){

        return this.lambdaQuery()
                .eq(!ObjectUtils.isEmpty(userId), UserArea::getUserId, userId)
                .list();
    }

}

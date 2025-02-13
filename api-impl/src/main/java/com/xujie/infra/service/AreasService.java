package com.xujie.infra.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xujie.infra.entity.Areas;
import com.xujie.infra.mapper.AreasMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
@Service
public class AreasService extends ServiceImpl<AreasMapper, Areas> {

    public List<Areas> getAreasByAreaIds(List<Long> areaIds) {
        return this.lambdaQuery()
                .in(!ObjectUtils.isEmpty(areaIds), Areas::getId, areaIds)
                .list();
    }
}

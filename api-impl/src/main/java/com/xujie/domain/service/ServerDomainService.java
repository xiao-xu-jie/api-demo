package com.xujie.domain.service;

import com.xujie.domain.entity.UserRequestBO;
import com.xujie.infra.entity.Areas;
import com.xujie.infra.entity.UserArea;
import com.xujie.infra.service.AreasService;
import com.xujie.infra.service.UserAreaService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
@Service
public class ServerDomainService {
    @Resource
    private AreasService areasService;
    @Resource
    private UserAreaService userAreaService;

    /**
     * 通过用户全地址组合 与 可用地址组合 进行前缀匹配校验是否可用
     *
     * @param userRequestBO
     * @return
     */
    public Boolean isAvailable(UserRequestBO userRequestBO) {
        Long userId = userRequestBO.getUserId();
        // 通过用户ID获取其可用区域
        List<UserArea> userAvailableAreas = userAreaService.getUserAvailableAreas(userId);
        if (ObjectUtils.isEmpty(userAvailableAreas)) {
            return false;
        }
        // 获取用户可用所有地区
        List<Long> areaIds = userAvailableAreas.stream().map(UserArea::getAreaId).toList();
        List<Areas> ares = areasService.getAreasByAreaIds(areaIds);
        String countryCode = userRequestBO.getCountryCode();
        String province = userRequestBO.getProvince();
        String city = userRequestBO.getCity();

        // 用户当前地址全组合
        String userFullLocation = String.join("-", countryCode, province, city);
        Predicate<Areas> check = (item) -> {
            // 通过前缀匹配进行检验
            String fullLocation = String.join("-", item.getCountryCode(), item.getProvince(), item.getCity());
            return StringUtils.startsWith(fullLocation, userFullLocation)
                    || StringUtils.startsWith(userFullLocation, fullLocation);
        };
        // 扩展....
        return ares.stream().anyMatch(check);
    }


}

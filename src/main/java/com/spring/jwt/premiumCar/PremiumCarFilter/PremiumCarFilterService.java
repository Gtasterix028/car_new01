package com.spring.jwt.premiumCar.PremiumCarFilter;

import com.spring.jwt.dto.FilterDto;
import com.spring.jwt.premiumCar.PremiumCarDto;

import java.util.List;

public interface PremiumCarFilterService {

    public List<PremiumCarDto> searchByFilter(FilterDto filterDto);

    List<PremiumCarDto> searchByFilterPage(FilterDto filterDto, int pageNo, int pageSize);

    public List<PremiumCarDto> getAllCarsWithPages(int PageNo,int pageSize);

    public List<PremiumCarDto> searchBarFilter(String searchBarInput,int PageNo);

    List<PremiumCarDto> getTop4Cars(String searchBarInput);
}




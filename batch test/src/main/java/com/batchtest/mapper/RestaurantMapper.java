package com.batchtest.mapper;


import com.batchtest.dto.CsvDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    public List<CsvDTO> select_restaurant();
    public void truncate_restaurant();

}

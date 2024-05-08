package com.rod.api.common.service;

import com.rod.api.common.model.PageDTO;

public interface PageService {
    PageDTO getPageDTO(Long totalCount, Long pageNumber, Long pageSize);
}

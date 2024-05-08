package com.rod.api.common.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Box {
    private PageDTO pageDTO;
    private List<?> list;

}

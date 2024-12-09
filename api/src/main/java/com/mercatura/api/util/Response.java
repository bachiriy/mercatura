package com.mercatura.api.util;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    int code;
    String status;
    List<String> success;
    List<String> errors;
}

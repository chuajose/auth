package com.chuajose.auth.domains.shared.errors.response;

import com.chuajose.auth.domains.shared.errors.model.ErrorModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private List<ErrorModel> errorMessage;

}
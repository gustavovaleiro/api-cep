package br.com.cep.exceptions.handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StandardError {

    private Integer statusCode;
    private String message;
    private Long timeStamp;
}

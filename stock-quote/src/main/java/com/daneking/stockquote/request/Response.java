package com.daneking.stockquote.request;

import lombok.Data;

@Data
class Response {
    private Quotes quotes;
    private String error;

}

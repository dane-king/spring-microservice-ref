package com.daneking.stockquote.request;

import lombok.Data;

//TODO After upgrade move to records
@Data
class Response {
    private Quotes quotes;
    private String error;

}

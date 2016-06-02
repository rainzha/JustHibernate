package org.rainzha.justhibernate.domain;

import lombok.Data;

@Data
public class Trade {
    private long tradeId = -1;
    private double quantity = 0;
    private String security = null;

}

package com.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "Exchange")
public class ExchangeModel {

    @Id
    private int id;

    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;
    private BigDecimal convertorRatio;
    private int port;

    @Override
    public String toString() {
        return "ExchangeModel{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", convertorRatio=" + convertorRatio +
                ", port=" + port +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConvertorRatio() {
        return convertorRatio;
    }

    public void setConvertorRatio(BigDecimal convertorRatio) {
        this.convertorRatio = convertorRatio;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

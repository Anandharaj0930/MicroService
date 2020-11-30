package com.customer.types;

public class CustomerResponse {
    private String orderCode;
    private String orderDescription;
    private Error error;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "orderCode='" + orderCode + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", error=" + error +
                '}';
    }
}

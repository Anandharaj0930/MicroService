package com.stock.types;

public class GetStockResponse {
    private String stockName;

    private String price;

    private String owner;

    private String type;

    private Data data;

    public class Data {
        private String statusCode;

        private String statusMsg;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusMsg() {
            return statusMsg;
        }

        public void setStatusMsg(String statusMsg) {
            this.statusMsg = statusMsg;
        }
    }


    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetStockResponse{" +
                "stockName='" + stockName + '\'' +
                ", price='" + price + '\'' +
                ", owner='" + owner + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}

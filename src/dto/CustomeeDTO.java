package dto;

import javafx.collections.ObservableList;

public class CustomeeDTO {
    ObservableList<OrdersDTO> orderDetailListt;
    ObservableList<ProductDTO> productListt;

    public CustomeeDTO() {
    }

    public CustomeeDTO(ObservableList<OrdersDTO> orderDetailListt, ObservableList<ProductDTO> productListt) {
        this.orderDetailListt = orderDetailListt;
        this.productListt = productListt;
    }

    public ObservableList<OrdersDTO> getOrderDetailListt() {
        return orderDetailListt;
    }

    public void setOrderDetailListt(ObservableList<OrdersDTO> orderDetailListt) {
        this.orderDetailListt = orderDetailListt;
    }

    public ObservableList<ProductDTO> getProductListt() {
        return productListt;
    }

    public void setProductListt(ObservableList<ProductDTO> productListt) {
        this.productListt = productListt;
    }
}

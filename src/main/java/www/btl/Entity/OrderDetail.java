package www.btl.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import www.btl.Entity.Order;



@Entity
@Table(name="order_items")
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = 7793469511895300150L;

	@Id
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product producid;
	
	@Id
	@ManyToOne()
	@JoinColumn(name="order_id")
	private Order orderId;
	
	private int quantity;
	
	@Column(nullable = true)
	private double price;	
	
	public OrderDetail(Product producId, Order orderId, int quantity) {
		super();
		this.producid = producId;
		this.orderId = orderId;
		this.quantity = quantity;
	}
	public OrderDetail() {
		super();
	}
	public Product getProducId() {
		return producid;
	}
	public void setProducId(Product producId) {
		this.producid = producId;
	}
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetail [producid=" + producid + ", orderId=" + orderId + ", quantity=" + quantity
				+ ", getProducId()=" + getProducId() + ", getOrderId()=" + getOrderId() + ", getQuantity()="
				+ getQuantity() + "]";
	}
	
	
	
	
	
}

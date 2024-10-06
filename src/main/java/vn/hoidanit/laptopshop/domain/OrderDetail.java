// package vn.hoidanit.laptopshop.domain;

// import jakarta.annotation.Generated;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "order_detail")
// public class OrderDetail {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private long id;

// // private long order_id;
// @ManyToOne
// @JoinColumn(name = "order_id")
// Order order;

// // private long product_id;
// @ManyToOne
// @JoinColumn(name = "product_id")
// Product product;

// private long quantity;
// private long price;
// }

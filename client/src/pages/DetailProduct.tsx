import React, { useState } from "react";
import laptopImage from "../assets/laptop.jpg";

interface Product {
  id: number;
  name: string;
  price: number;
  description: string;
  image: string;
  stock: number;
}

const DetailProduct = () => {
  const [product] = useState<Product>({
    id: 1,
    name: "Laptop Dell XPS 13",
    price: 25000000,
    description:
      "Laptop cao cấp với cấu hình mạnh mẽ, pin 15 giờ, thiết kế nhỏ gọn",
    image: laptopImage,
    stock: 10,
  });

  const [quantity, setQuantity] = useState(1);

  const handlePlaceOrder = () => {
    alert(`Đã đặt hàng ${quantity} sản phẩm: ${product.name}`);
  };

  const handleQuantityChange = (newValue: number) => {
    const validValue = Math.max(1, Math.min(newValue, product.stock));
    setQuantity(validValue);
  };

  return (
    <div
      style={{
        minHeight: "100vh",
        backgroundColor: "#f8f9fa",
        padding: "40px 20px",
        fontFamily: "'Segoe UI', Tahoma, Geneva, Verdana, sans-serif",
      }}
    >
      <div
        style={{
          maxWidth: "1000px",
          margin: "0 auto",
          backgroundColor: "white",
          borderRadius: "12px",
          boxShadow: "0 2px 12px rgba(0, 0, 0, 0.08)",
          overflow: "hidden",
        }}
      >
        <div
          style={{
            display: "grid",
            gridTemplateColumns: "1fr 1fr",
            gap: "50px",
            padding: "40px",
          }}
        >
          {/* Hình ảnh sản phẩm */}
          <div>
            <div
              style={{
                backgroundColor: "#f5f5f5",
                borderRadius: "10px",
                overflow: "hidden",
                aspectRatio: "1",
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                boxShadow: "0 4px 10px rgba(0, 0, 0, 0.05)",
              }}
            >
              <img
                src={product.image}
                alt={product.name}
                style={{
                  width: "100%",
                  height: "100%",
                  objectFit: "cover",
                }}
              />
            </div>
          </div>

          {/* Thông tin sản phẩm */}
          <div style={{ display: "flex", flexDirection: "column" }}>
            <h1
              style={{
                fontSize: "32px",
                fontWeight: "700",
                marginBottom: "15px",
                color: "#1a1a1a",
              }}
            >
              {product.name}
            </h1>

            {/* Giá */}
            <div
              style={{
                fontSize: "36px",
                color: "#e74c3c",
                fontWeight: "700",
                marginBottom: "5px",
              }}
            >
              {product.price.toLocaleString("vi-VN")} đ
            </div>

            {/* Kho hàng */}
            <div
              style={{
                marginBottom: "25px",
                paddingBottom: "25px",
                borderBottom: "1px solid #e8e8e8",
              }}
            >
              <span
                style={{
                  color: "#27ae60",
                  fontWeight: "600",
                  fontSize: "16px",
                  display: "inline-flex",
                  alignItems: "center",
                  gap: "6px",
                }}
              >
                ✓ Còn {product.stock} sản phẩm
              </span>
            </div>

            {/* Mô tả */}
            <p
              style={{
                color: "#555",
                lineHeight: "1.8",
                marginBottom: "30px",
                fontSize: "16px",
              }}
            >
              {product.description}
            </p>

            {/* Chọn số lượng */}
            <div
              style={{
                marginBottom: "30px",
              }}
            >
              <label
                style={{
                  fontWeight: "600",
                  fontSize: "16px",
                  color: "#1a1a1a",
                  display: "block",
                  marginBottom: "12px",
                }}
              >
                Chọn số lượng
              </label>
              <div
                style={{
                  display: "flex",
                  alignItems: "center",
                  gap: "10px",
                }}
              >
                <div
                  style={{
                    display: "flex",
                    alignItems: "center",
                    border: "2px solid #e8e8e8",
                    borderRadius: "8px",
                    backgroundColor: "#f9f9f9",
                  }}
                >
                  <button
                    onClick={() => handleQuantityChange(quantity - 1)}
                    disabled={quantity <= 1}
                    style={{
                      padding: "10px 14px",
                      border: "none",
                      background: "transparent",
                      cursor: quantity <= 1 ? "not-allowed" : "pointer",
                      fontSize: "18px",
                      fontWeight: "600",
                      color: quantity <= 1 ? "#ccc" : "#e74c3c",
                      transition: "color 0.2s",
                    }}
                    onMouseEnter={(e) => {
                      if (quantity > 1) e.currentTarget.style.color = "#c0392b";
                    }}
                    onMouseLeave={(e) => {
                      if (quantity > 1) e.currentTarget.style.color = "#e74c3c";
                    }}
                  >
                    −
                  </button>
                  <input
                    type="number"
                    value={quantity}
                    onChange={(e) => {
                      let newValue = parseInt(e.target.value);
                      if (isNaN(newValue) || newValue < 1) {
                        newValue = 1;
                      } else if (newValue > product.stock) {
                        newValue = product.stock;
                      }
                      setQuantity(newValue);
                    }}
                    style={{
                      width: "60px",
                      textAlign: "center",
                      border: "none",
                      padding: "10px 0",
                      fontSize: "16px",
                      fontWeight: "600",
                      backgroundColor: "transparent",
                      color: "#333",
                    }}
                    min="1"
                    max={product.stock}
                  />
                  <button
                    onClick={() => handleQuantityChange(quantity + 1)}
                    disabled={quantity >= product.stock}
                    style={{
                      padding: "10px 14px",
                      border: "none",
                      background: "transparent",
                      cursor:
                        quantity >= product.stock ? "not-allowed" : "pointer",
                      fontSize: "18px",
                      fontWeight: "600",
                      color: quantity >= product.stock ? "#e74c3c" : "#e74c3c",
                      transition: "color 0.2s",
                    }}
                    onMouseEnter={(e) => {
                      if (quantity < product.stock)
                        e.currentTarget.style.color = "#c0392b";
                    }}
                    onMouseLeave={(e) => {
                      if (quantity < product.stock)
                        e.currentTarget.style.color = "#e74c3c";
                    }}
                  >
                    +
                  </button>
                </div>
                <span style={{ color: "#999", fontSize: "14px" }}>
                  Tối đa: {product.stock}
                </span>
              </div>
            </div>

            {/* Nút đặt hàng */}
            <button
              onClick={handlePlaceOrder}
              style={{
                padding: "16px 24px",
                fontSize: "18px",
                fontWeight: "700",
                color: "white",
                backgroundColor: "#e74c3c",
                border: "none",
                borderRadius: "8px",
                cursor: "pointer",
                transition: "all 0.3s ease",
                boxShadow: "0 4px 12px rgba(231, 76, 60, 0.3)",
              }}
              onMouseEnter={(e) => {
                e.currentTarget.style.backgroundColor = "#c0392b";
                e.currentTarget.style.boxShadow =
                  "0 6px 16px rgba(231, 76, 60, 0.4)";
                e.currentTarget.style.transform = "translateY(-2px)";
              }}
              onMouseLeave={(e) => {
                e.currentTarget.style.backgroundColor = "#e74c3c";
                e.currentTarget.style.boxShadow =
                  "0 4px 12px rgba(231, 76, 60, 0.3)";
                e.currentTarget.style.transform = "translateY(0)";
              }}
            >
              🛒 Đặt Hàng Ngay
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DetailProduct;

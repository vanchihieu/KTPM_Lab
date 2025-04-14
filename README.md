# KTPM_Lab - Hệ thống quản lý bán hàng với Microservices

## Tổng quan
Dự án này xây dựng hệ thống quản lý bán hàng đơn giản bằng kiến trúc Microservices sử dụng Java Spring Boot.

## Các thành phần chính
- Product Service: Quản lý thông tin sản phẩm (tên, giá, mô tả, tồn kho)
- Order Service: Quản lý đơn hàng (tạo, xem, hủy đơn hàng)
- Customer Service: Quản lý thông tin khách hàng (tên, địa chỉ, thông tin liên lạc)
- API Gateway: Điểm truy cập duy nhất cho các client
- Message Broker: Truyền tải thông điệp giữa các Microservices (RabbitMQ)

## Công nghệ sử dụng
- Java Spring Boot
- Spring Cloud
- Docker & Docker Compose
- RabbitMQ
- RESTful APIs
- MySQL (mỗi service sử dụng database riêng)

## Cấu trúc dự án
- `/product-service`: Quản lý thông tin sản phẩm
- `/order-service`: Quản lý đơn hàng
- `/customer-service`: Quản lý thông tin khách hàng  
- `/api-gateway`: API Gateway
- `/discovery-server`: Service Discovery (Eureka Server)
- `/docker-compose.yml`: Cấu hình Docker Compose

## Minh chứngchứng
![Image](https://github.com/user-attachments/assets/15724685-2fa4-4e35-ae5d-397dba0b2f30)

![Image](https://github.com/user-attachments/assets/8c862f9d-013b-4cbf-88d4-220886b89262)

![Image](https://github.com/user-attachments/assets/8514b6c3-42b9-496e-ac7c-3e3c8ddc5857)
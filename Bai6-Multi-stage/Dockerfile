# Stage 1: Build (vẫn cần Node.js để chạy)
FROM node:18 AS builder

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép file server vào container
COPY server.js .

# Stage 2: Chạy ứng dụng với Node.js Alpine (nhẹ hơn)
FROM node:18-alpine AS runner

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép server.js từ Stage 1
COPY --from=builder /app/server.js .

# Expose port
EXPOSE 3000

# Chạy ứng dụng
CMD ["node", "server.js"]

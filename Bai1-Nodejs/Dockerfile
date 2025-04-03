# Sử dụng base image node:18
FROM node:18

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép file server.js vào container
COPY server.js .

# Chạy ứng dụng Node.js
CMD ["node", "server.js"]

# Mở cổng 3000 để truy cập ứng dụng
EXPOSE 3000
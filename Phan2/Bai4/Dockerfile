# Sử dụng Node.js base image
FROM node:18

# Tạo thư mục app
WORKDIR /app

# Copy file và cài đặt
COPY package*.json ./
RUN npm install

# Copy phần còn lại
COPY . .

# Mở cổng ứng dụng
EXPOSE 3000

# Lệnh chạy app
CMD ["npm", "start"]

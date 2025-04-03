# Sử dụng base image nginx:latest
FROM nginx:latest

# Sao chép file index.html vào thư mục mặc định của Nginx
COPY index.html /usr/share/nginx/html/index.html

# Mở cổng 80 (cổng mặc định của Nginx)
EXPOSE 80

# Lệnh CMD không cần thiết vì image nginx:latest đã có lệnh mặc định để chạy Nginx
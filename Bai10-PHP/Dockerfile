# Sử dụng image chính thức của PHP 8.2 với Apache
FROM php:8.2-apache

# Copy mã nguồn vào thư mục mặc định của Apache
COPY ./index.php /var/www/html/

# Mở cổng 80 để truy cập web
EXPOSE 80

# Chạy Apache với PHP
CMD ["apache2-foreground"]

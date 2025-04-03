# Sử dụng image chính thức của Redis
FROM redis:latest

# Sao chép file redis.conf vào container
COPY redis.conf /usr/local/etc/redis/redis.conf

# Chạy Redis với cấu hình tùy chỉnh
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]

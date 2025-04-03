# Sử dụng Python 3.11 làm base image
FROM python:3.11-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file app.py vào container
COPY app.py .

# Thiết lập biến môi trường
ENV APP_ENV=development

# Chạy ứng dụng
CMD ["python", "app.py"]

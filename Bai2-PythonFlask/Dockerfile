# Sử dụng base image python:3.9
FROM python:3.9

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép file requirements.txt và cài đặt dependencies
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# Sao chép file app.py vào container
COPY app.py .

# Chạy ứng dụng Flask
CMD ["python", "app.py"]

# Mở cổng 5000 để truy cập ứng dụng
EXPOSE 5000
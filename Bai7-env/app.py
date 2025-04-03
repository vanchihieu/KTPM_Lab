import os

# Đọc biến môi trường APP_ENV, mặc định là 'development'
app_env = os.getenv("APP_ENV", "development")

print(f"Application is running in {app_env} mode.")

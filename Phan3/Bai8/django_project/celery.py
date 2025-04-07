from __future__ import absolute_import, unicode_literals
import os
from celery import Celery

# Cài đặt môi trường Django
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'django_project.settings')

# Khởi tạo Celery app
app = Celery('django_project')

# Cấu hình Celery từ Django settings
app.config_from_object('django.conf:settings', namespace='CELERY')

# Tìm các task đã được đăng ký trong Django
app.autodiscover_tasks()

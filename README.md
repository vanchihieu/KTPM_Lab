## API Endpoints

### 1. Đăng ký (Register)
```http
POST http://localhost:8080/sign-up
```
- **Body:**
```json
{
    "userName" : "vanchihieu",
    "email": "vanchihieu@gmail.com",
    "password": "12345678"
}
```
- **Response:**
```json
{
    "status": "SUCCESS",
    "message": "User account has been successfully created!",
    "response": null
}
```

![Image](https://github.com/user-attachments/assets/0cc56e7c-9f82-4b62-9e44-5e060a6d373a)

### 2. Đăng nhập (Login)
```http
POST http://localhost:8080/sign-up
```
- **Body:**
```json
{
  "userName": "vanchihieu",
  "password": "12345678",
}
```
- **Response:**
```json
{
    "status": "",
    "message": "",
    "response": {
        "token": "",
        "type": "",
        "id": 2,
        "username": "",
        "email": "",
        "roles": []
    }
}
```

![Image](https://github.com/user-attachments/assets/e23a373a-5584-4749-9ffc-a14a1af12dd2)
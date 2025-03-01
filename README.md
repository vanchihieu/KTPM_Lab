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
POST http://localhost:8080/sign-in
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

### 3. Admin Message (admin-message)
```http
POST http://localhost:8080/api/admin-message
```
- **Body:**
``` Need Bearer Token

```
- **Response:**
```json
{
    "Welcome to Admin Role: [SCOPE_ROLE_ADMIN, SCOPE_PERMISSION_UPDATE, SCOPE_PERMISSION_READ, SCOPE_PERMISSION_WRITE]"
}
```

![Image](https://github.com/user-attachments/assets/907a3db8-5e05-4da4-9f10-56d9c0a6826d)
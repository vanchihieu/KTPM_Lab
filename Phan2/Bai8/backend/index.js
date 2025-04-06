const express = require("express");
const mysql = require("mysql2");
const app = express();
const port = 3000;

// Kết nối MySQL (host là tên service trong docker-compose)
const db = mysql.createConnection({
  host: "mysql",
  user: "user",
  password: "password",
  database: "mydb",
});

db.connect((err) => {
  if (err) {
    console.error("Không thể kết nối MySQL:", err);
    return;
  }
  console.log("Đã kết nối MySQL!");
});

app.get("/", (req, res) => {
  db.query("SELECT NOW() AS now", (err, result) => {
    if (err) return res.send("Lỗi truy vấn");
    res.send(`Giờ MySQL hiện tại: ${result[0].now}`);
  });
});

app.listen(port, () => {
  console.log(`App đang chạy tại http://localhost:${port}`);
});

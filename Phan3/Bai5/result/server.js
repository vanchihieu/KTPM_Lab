const express = require("express");
const { Pool } = require("pg");
const app = express();

const pool = new Pool({
  host: "db",
  user: "postgres",
  password: "postgres",
  database: "votes",
});

app.get("/", async (req, res) => {
  const { rows } = await pool.query(
    "SELECT vote, COUNT(*) FROM votes GROUP BY vote"
  );
  res.send(rows.map((row) => `${row.vote}: ${row.count}`).join("<br>"));
});

app.listen(80, () => {
  console.log("Result app listening on port 80");
});

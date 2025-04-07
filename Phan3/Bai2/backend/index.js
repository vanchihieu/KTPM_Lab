const express = require("express");
const mongoose = require("mongoose");

const app = express();
app.use(express.json());

const mongoUrl = process.env.MONGO_URL || "mongodb://localhost:27017/mydb";

mongoose
  .connect(mongoUrl, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log("✅ Connected to MongoDB"))
  .catch((err) => console.error("❌ MongoDB connection error:", err));

// Simple schema & model
const Item = mongoose.model("Item", { name: String });

// Routes
app.get("/", (req, res) => res.send("Hello from Node + MongoDB!"));

app.post("/items", async (req, res) => {
  const item = new Item({ name: req.body.name });
  await item.save();
  res.json(item);
});

app.get("/items", async (req, res) => {
  const items = await Item.find();
  res.json(items);
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`🚀 Server running on port ${PORT}`);
});

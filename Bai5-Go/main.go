package main

import (
    "fmt"
    "net/http"
    "log"
)

func handler(w http.ResponseWriter, r *http.Request) {
    fmt.Fprintf(w, "Hello, Docker Go!")
}

func main() {
    http.HandleFunc("/", handler)
    fmt.Println("Server started at http://localhost:8081")
    log.Fatal(http.ListenAndServe(":8080", nil))
}
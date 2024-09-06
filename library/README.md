To build run

```bash
go build -buildmode=c-shared -o bin/library.so main.go
```

For the completeness sake I've commited the `library.so` and `library.h` files in the `bin` folder.
You generally shouldn't commit those files!

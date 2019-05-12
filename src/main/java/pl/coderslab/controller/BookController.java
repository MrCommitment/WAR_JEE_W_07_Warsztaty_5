package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pl.coderslab.entity.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MemoryBookService memoryBookService;

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable long id) {
        memoryBookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable long id, @RequestBody Book book) {
        memoryBookService.updateBook(id, book);
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addBook(@RequestBody Book book) {
        System.out.println(book.toString());
        memoryBookService.addBook(book);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBook(@PathVariable(required = true) long id) {
        return memoryBookService.getBook(id);
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBooks() {
        return memoryBookService.getList();
    }

    @RequestMapping("/hello")
    @ResponseStatus(value = HttpStatus.OK)
    public String hello() {
        return "{hello: World}";
    }
}

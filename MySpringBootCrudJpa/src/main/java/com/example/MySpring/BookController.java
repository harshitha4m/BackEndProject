package com.example.MySpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/showAllBooks")
	public String showBooksList(Model model) {
		System.out.println("-------BookController--showBooksList()---------");
		List<Book> blist = bookService.getAllBooks();
		model.addAttribute("MyBooksList", blist);
		return "booksList";
	}

	@PostMapping("/addEditBookForm")
	public String addBookForm(@RequestParam("bookId") Integer bookId, Model model) {
		System.out.println("-------BookController--addEditBookForm()---------");
		System.out.println(bookId);
		Book book = new Book();
		String opType = "ADD";
		if (bookId != 0) {
			book = bookService.getBookById(bookId);
			opType = "UPDATE";
		}
		model.addAttribute("mybook", book);
		model.addAttribute("OpType", opType);
		return "addEditBook";
	}

	@PostMapping("/saveUpdateBook")
	public String saveUpdateBook(@Valid @ModelAttribute("mybook") Book book, BindingResult result, Model model,
			HttpServletRequest req) {
		System.out.println("-------BookController--saveUpdateBook()---------");
		String opType = req.getParameter("OpType");
		System.out.println(opType);
		if (opType.equals("ADD")) {
			bookService.addBook(book);
		}
		if (opType.equals("UPDATE")) {
			bookService.updateBook(book);
		}
		List<Book> blist = bookService.getAllBooks();
		model.addAttribute("MyBooksList", blist);
		return "booksList";
	}

	@PostMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") Integer bookId, Model model) {
		System.out.println("-------BookController--deleteBook()---------");
		bookService.deleteBook(bookId);
		List<Book> blist = bookService.getAllBooks();
		model.addAttribute("MyBooksList", blist);
		return "booksList";
	}

	@GetMapping("/viewBook")
	public String viewBook(@RequestParam("bookId") String bookId, Model model) {
		System.out.println("-------BookController--viewBook()---------");
		System.out.println(bookId);
		Book book = bookService.getBookById(Integer.parseInt(bookId));
		model.addAttribute("MyBook", book);
		return "viewBook";
	}
}
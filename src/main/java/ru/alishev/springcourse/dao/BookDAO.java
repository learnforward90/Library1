package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;

import java.sql.ResultSet;
import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(book_name, book_author, book_year) VALUES(?, ?, ?)",
                book.getBookName(), book.getBookAuthor(), book.getBookYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET book_name=?, book_author=?, book_year=? WHERE book_id=?",
                updatedBook.getBookName(), updatedBook.getBookAuthor(), updatedBook.getBookYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }


    public Person checkPerson(int id){

        Integer number = jdbcTemplate.queryForObject("SELECT person_id FROM BOOK where book_id = ?", new Object[]{id}, Integer.class);
        Person person = jdbcTemplate.query("select * from Person where id=?", new Object[]{number},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
        System.out.println(person);
        return person;
    }

    public void releaseBook(int bookId){
        jdbcTemplate.update("update book set person_id = null where book_id = ?", bookId);
    }
    public void giveBook(int personId, int bookId){
        jdbcTemplate.update("update book set person_id = ? where book_id = ?", personId, bookId);
    }

}

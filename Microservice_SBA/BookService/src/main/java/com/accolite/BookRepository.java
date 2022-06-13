package com.accolite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value="select * from books b where b.book_name=?1",nativeQuery = true)
	Book findCostByBookName(String bookName);

}

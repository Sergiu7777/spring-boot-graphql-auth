package com.example.springgraphqlsecurity.repository;

import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
//    Library findLibraryByAddress(String address);

//    @Query()
//    List<Library> findAllByBook(Book book);
}

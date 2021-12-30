package io.dotinc.springapi.repository;

import io.dotinc.springapi.FakerUtil;
import io.dotinc.springapi.model.BookModel;
import io.dotinc.springapi.model.BookStoreModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookStoreRepository {
    //Consider the list of book stores as the database
    private static List<BookStoreModel> bookStores = FakerUtil.initBookStores();

    public List<BookModel> findAllForStore(String storeId) {
        return bookStores.stream()
                .filter(b -> storeId.equals(b.getId()))
                .findFirst().map(BookStoreModel::getBooks)
                .orElse(new ArrayList<>());
    }
}

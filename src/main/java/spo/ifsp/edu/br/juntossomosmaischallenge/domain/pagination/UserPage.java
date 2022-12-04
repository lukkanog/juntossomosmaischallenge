package spo.ifsp.edu.br.juntossomosmaischallenge.domain.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPage<T> extends PageImpl<T> {
    private int pageNumber;
    private int pageSize;
    private long totalCount;
    private List<T> users;

    public UserPage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public UserPage(List<T> content) {
        super(content);
    }

    public UserPage() {
        super(new ArrayList<T>());
    }

    public PageImpl<T> pageImpl() {
        return new PageImpl<T>(
            getContent(), 
            PageRequest.of(pageNumber, pageSize),
            getTotalElements());
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getUsers() {
        return users;
    }

    public void setUsers(List<T> users) {
        this.users = users;
    }

    public static <T> UserPage<T> of(Page<T> page) {
      UserPage<T> UserPage = new UserPage<T>();
      UserPage.setPageNumber(page.getNumber());
      UserPage.setPageSize(page.getSize());
      UserPage.setTotalCount(page.getTotalElements());
      UserPage.setUsers(page.getContent());
      return UserPage;
  }

    @Override
    @JsonIgnore
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    @JsonIgnore
    public int getSize() {
        return super.getSize();
    }

    @Override
    @JsonIgnore
    public int getNumberOfElements() {
        return super.getNumberOfElements();
    }

    @Override
    @JsonIgnore
    public List<T> getContent() {
        return super.getContent();
    }

    @Override
    @JsonIgnore
    public boolean hasContent() {
        return super.hasContent();
    }

    @Override
    @JsonIgnore
    public Sort getSort() {
        return super.getSort();
    }

    @Override
    @JsonIgnore
    public boolean isFirst() {
        return super.isFirst();
    }

    @Override
    @JsonIgnore
    public boolean isLast() {
        return super.isLast();
    }

    @Override
    @JsonIgnore
    public boolean hasNext() {
        return super.hasNext();
    }

    @Override
    @JsonIgnore
    public boolean hasPrevious() {
        return super.hasPrevious();
    }

    @Override
    @JsonIgnore
    public int getTotalPages() {
        return super.getTotalPages();
    }

    @Override
    @JsonIgnore
    public long getTotalElements() {
        return super.getTotalElements();
    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    @JsonIgnore
    public Pageable getPageable() {
        return super.getPageable();
    }
}

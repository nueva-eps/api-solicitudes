package com.nuevaeps.api_solicitudes.domain.model;

import java.util.List;

public class PaginacionResponse<T> {
    private final List<T> content;
    private final int currentPage;
    private final int totalPages;
    private final long totalElements;

    public PaginacionResponse(List<T> content, int currentPage, int size, long totalElements) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalElements = totalElements;
        int calculoPaginas = (int) Math.ceil((double) totalElements / size);
        this.totalPages = calculoPaginas == 0 ? 1 : calculoPaginas;
    }

    public List<T> getContent() { return content; }
    public int getCurrentPage() { return currentPage; }
    public int getTotalPages() { return totalPages; }
    public long getTotalElements() { return totalElements; }
}

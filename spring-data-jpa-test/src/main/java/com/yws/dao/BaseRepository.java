package com.yws.dao;

public interface BaseRepository<D,T> {
    D findWithGraph(T id, String graphyName);
}

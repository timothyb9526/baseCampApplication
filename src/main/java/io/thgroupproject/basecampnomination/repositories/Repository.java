package io.thgroupproject.basecampnomination.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repository<T> {
    List<T> findAll();

    Optional<T> findById(UUID id);

    void save(T t);
}

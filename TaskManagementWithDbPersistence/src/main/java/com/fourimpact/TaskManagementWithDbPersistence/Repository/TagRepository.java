package com.fourimpact.TaskManagementWithDbPersistence.Repository;

import com.fourimpact.TaskManagementWithDbPersistence.Model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {

    public boolean existsByName(String name);

    public Page<Tag> findAll(Pageable pageable);
}

package com.fourimpact.TaskManagementWithDbPersistence.Repository;

import com.fourimpact.TaskManagementWithDbPersistence.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

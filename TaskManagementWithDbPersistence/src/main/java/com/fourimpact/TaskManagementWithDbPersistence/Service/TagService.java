package com.fourimpact.TaskManagementWithDbPersistence.Service;

import com.fourimpact.TaskManagementWithDbPersistence.Model.Tag;
import com.fourimpact.TaskManagementWithDbPersistence.Repository.TagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    // Create Tag
    public Tag createTag(Tag tag){

        if(tag.getName() == null || tag.getName().isEmpty()){
            throw new IllegalArgumentException("Tag name cannot be empty");
        }

        if(tagRepository.existsByName(tag.getName().trim())){
            throw new IllegalArgumentException("Tag already exists");
        }
        tag.setName(tag.getName().trim());

        return tagRepository.save(tag);
    }

    // Read
    @Transactional(readOnly = true)
    public Page<Tag> getAllTags(Pageable pageable){
        return tagRepository.findAll(pageable);
    }
}

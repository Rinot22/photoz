package com.rinot22.photoz_clone.repository;

import com.rinot22.photoz_clone.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}

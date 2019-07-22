package com.config.db.serivce.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.config.db.serivce.model.CommonPrimeryKey;
import com.config.db.serivce.model.Online;

@Repository
public interface OnlineRepository extends CrudRepository<Online, CommonPrimeryKey> {

}

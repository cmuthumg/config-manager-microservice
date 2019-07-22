package com.config.db.serivce.repository;

import org.springframework.data.repository.CrudRepository;

import com.config.db.serivce.model.CommonPrimeryKey;
import com.config.db.serivce.model.Offline;

public interface OfflineRepository extends CrudRepository<Offline, CommonPrimeryKey> {

}

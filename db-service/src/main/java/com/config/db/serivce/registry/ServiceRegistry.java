package com.config.db.serivce.registry;

public interface ServiceRegistry<U> {
	public <T> AdapterService<T, U> getService(String serviceName);
}

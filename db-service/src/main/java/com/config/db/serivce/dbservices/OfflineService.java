
package com.config.db.serivce.dbservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.db.serivce.bean.RequestBean;
import com.config.db.serivce.bean.ResponseBean;
import com.config.db.serivce.model.CommonPrimeryKey;
import com.config.db.serivce.model.Offline;
import com.config.db.serivce.registry.AdapterService;
import com.config.db.serivce.repository.OfflineRepository;

@Service("offline")
public class OfflineService implements AdapterService<RequestBean, ResponseBean> {
	@Autowired
	OfflineRepository offlineRepository;

	@Override
	public ResponseBean getConfigData(String id, String status) {
		Offline data = null;
		data = offlineRepository.findOne(new CommonPrimeryKey(id, status));
		return new ResponseBean(data.getPrimeryKey().getServiceContextName(), data.getPrimeryKey().getStatus(),
				data.getContent());
	}

	@Override
	public ResponseBean saveconfigData(RequestBean data) {
		Offline saveData = new Offline(data.getServiceContextName(), data.getStatus(), data.getContent());
		offlineRepository.save(saveData);
		return new ResponseBean(data.getServiceContextName(), data.getStatus(), data.getContent());
	}

	@Override
	public ResponseBean updateConfigData(RequestBean data) {

		Offline saveData = new Offline(data.getServiceContextName(), data.getStatus(), data.getContent());
		offlineRepository.save(saveData);
		return new ResponseBean(data.getServiceContextName(), data.getStatus(), data.getContent());
	}

	@Override
	public void deleteConfigData(String id, String status) {
		offlineRepository.delete(offlineRepository.findOne(new CommonPrimeryKey(id, status)));
	}

	@Override
	public List<ResponseBean> getAllService() {
		List<ResponseBean> responseBeans = new ArrayList<>();
		offlineRepository.findAll().forEach(online -> {
			responseBeans.add(new ResponseBean(online.getPrimeryKey().getServiceContextName(),
					online.getPrimeryKey().getStatus(), online.getContent()));
		});
		return responseBeans;
	}

}

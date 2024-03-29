package com.config.db.serivce.dbservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.db.serivce.bean.RequestBean;
import com.config.db.serivce.bean.ResponseBean;
import com.config.db.serivce.model.CommonPrimeryKey;
import com.config.db.serivce.model.Online;
import com.config.db.serivce.registry.AdapterService;
import com.config.db.serivce.repository.OnlineRepository;

@Service("online")
public class OnlineService implements AdapterService<RequestBean, ResponseBean> {

	@Autowired
	OnlineRepository onlineRepository;

	@Override
	public ResponseBean getConfigData(String id, String status) {
		Online data = null;
		data = onlineRepository.findOne(new CommonPrimeryKey(id, status));
		return new ResponseBean(data.getPrimeryKey().getServiceContextName(), data.getPrimeryKey().getStatus(),
				data.getContent());
	}

	@Override
	public ResponseBean saveconfigData(RequestBean data) {
		Online saveData = new Online(data.getServiceContextName(), data.getStatus(), data.getContent());
		onlineRepository.save(saveData);
		return new ResponseBean(data.getServiceContextName(), data.getStatus(), data.getContent());
	}

	@Override
	public ResponseBean updateConfigData(RequestBean data) {

		Online saveData = new Online(data.getServiceContextName(), data.getStatus(), data.getContent());
		onlineRepository.save(saveData);
		return new ResponseBean(data.getServiceContextName(), data.getStatus(), data.getContent());
	}

	@Override
	public void deleteConfigData(String id, String status) {
		onlineRepository.delete(onlineRepository.findOne(new CommonPrimeryKey(id, status)));
	}

	@Override
	public List<ResponseBean> getAllService() {
		List<ResponseBean> responseBeans = new ArrayList<>();
		onlineRepository.findAll().forEach(online -> {
			responseBeans.add(new ResponseBean(online.getPrimeryKey().getServiceContextName(),
					online.getPrimeryKey().getStatus(), online.getContent()));
		});
		return responseBeans;
	}

}

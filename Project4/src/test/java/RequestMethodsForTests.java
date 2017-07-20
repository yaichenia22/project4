import java.util.ArrayList;
import java.util.List;

import entity.Request;
import service.request.RequestService;

public class RequestMethodsForTests extends RequestService {

	@Override
	public List<Request> getUnconsideredRequests() {
		return new ArrayList<>();
	}
	
	@Override
	public List<Request> getDoneRequests() {
		return new ArrayList<>();
	}
	 
}

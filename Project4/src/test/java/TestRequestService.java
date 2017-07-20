import java.util.List;

import org.junit.Test;

import entity.Request;
import service.request.RequestService;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestRequestService {
	
	@Test
	public void testUnconsideredRequests() {
		Request testRequest = new Request();
		RequestService service = new RequestMethodsForTests();
		List<Request> testList = service.getUnconsideredRequests();
		
		assertThat(testList, not(contains(testRequest)));
	}
	
	@Test
	public void testDoneRequests(){
		Request testRequest = new Request();
		RequestService service = new RequestMethodsForTests();
		List<Request> testList = service.getDoneRequests();
		
		assertThat(testList, not(contains(testRequest)));
	}
}

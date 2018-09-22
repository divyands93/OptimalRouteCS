package io.project.gridRoute.Graph;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class GridController {
	@Autowired
	private GridService gridService;
	
	@RequestMapping(method=RequestMethod.POST, value="/routes")
	public ResponseEntity<String> addRoute(@RequestBody String graphs) throws JsonParseException, JsonParseException, IOException {
		String message = gridService.addRoute(graphs);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getroutes")
	public ResponseEntity<Graph> getRoute() throws JsonParseException, JsonMappingException, IOException {
		Graph s= gridService.getRoute();
		
		return new ResponseEntity<Graph>(s,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/routes")
	public ResponseEntity<Graph> updateRoute(@RequestBody String edge) throws JsonParseException, JsonMappingException, IOException {
		Graph s= gridService.updateRoute(edge);
		return new ResponseEntity<Graph>(s,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getShortestRoute/{vertex1}/{vertex2}")
	public ResponseEntity getShortestPathRoute(@PathVariable String vertex1,@PathVariable String vertex2) throws JsonParseException, JsonMappingException, IOException {
		 gridService.getShortestPathRoute(vertex1,vertex2);
		
		return new ResponseEntity(HttpStatus.OK);
	}
}

package io.project.gridRoute.Graph;
import java.io.IOException;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GridService {
	Graph graph = new Graph();

	@SuppressWarnings("unused")
	public String addRoute(String graphs) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		graph = objectMapper.readValue(graphs,Graph.class);
		Vertex[] vertexes=graph.getVertexes();
		Edge[] edges=graph.getEdges();
		for(int i=0;i<vertexes.length;i++)
		{
			for(int j=0;j<edges.length;j++)
			{
				if(edges[j].getFromVertex().getVertexName().equals(vertexes[i].getVertexName()))
				{
					
					vertexes[i].addEdge(edges[j]);
				}
			}
		}
		graph.setVertexes(vertexes);
		return "Route Successfully created";
	}
	public Graph getRoute()  {
		return graph;
	}

	public Graph updateRoute(String edge) throws JsonParseException, JsonMappingException, IOException {
		Edge[] edges=graph.getEdges();
		ObjectMapper objectMapper = new ObjectMapper();
		Edge updateEdge = objectMapper.readValue(edge,Edge.class);
		for(int i=0;i<edges.length;i++) {
			if(edges[i].getFromVertex().getVertexName().equals(updateEdge.getFromVertex().getVertexName()) && edges[i].getToVertex().getVertexName().equals(updateEdge.getToVertex().getVertexName())) {
				edges[i].setWeight(updateEdge.getWeight());
			}
		}
		graph.setEdges(edges);
		return graph;
	}
	public void getShortestPathRoute(String vertex1,String vertex2) {
		// TODO Auto-generated method stub
		
		Dijkstra dijkstra = new Dijkstra();
        Vertex begin = dijkstra.getVertexByName(graph,vertex1);
        Vertex end = dijkstra.getVertexByName(graph,vertex2);
       // dijkstra.printGraph(graph);
        //dijkstra.printGrap
      dijkstra.printShortestPath(graph,begin,end);
		//return null;
	}
	
}

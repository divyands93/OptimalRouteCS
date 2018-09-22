package io.project.gridRoute.Graph;

import io.project.gridRoute.Graph.Edge;
import io.project.gridRoute.Graph.Vertex;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Graph {
	@JsonProperty
    private Vertex[] vertexes = null;
	@JsonProperty
    private Edge[] edges = null;

   public Graph(){};

    public Graph(Vertex[] vertexes, Edge[] edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public Vertex[] getVertexes() {
        return this.vertexes;
    }
    public void setVertexes(Vertex[] vertex)
    {
    	this.vertexes=vertex;
    }
    
    public void setEdges(Edge[] edge)
    {
    	this.edges=edge;
    }
    
    public Edge[] getEdges()
    {
    	return edges;
    }
    
    

}
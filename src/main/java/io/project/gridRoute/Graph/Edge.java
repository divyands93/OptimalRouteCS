package io.project.gridRoute.Graph;

import io.project.gridRoute.Graph.Vertex;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Edge {
	@JsonIgnore
    private boolean isVisited = false;

    private Integer weight = null;
    private Vertex fromVertex = null;

    private Vertex toVertex = null;

    public Edge(int weight, Vertex fromVertex, Vertex toVertex) {
    	this.weight = weight;
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
    }
    
    public Edge() {
    	
    }
   
    public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setFromVertex(Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}

	public void setToVertex(Vertex toVertex) {
		this.toVertex = toVertex;
	}

	public Integer getWeight() {
        return weight;
    }


    public Vertex getFromVertex() {
        return fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited() {
        isVisited = true;
    }
}
